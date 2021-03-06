package com.carlosdv93.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.carlosdv93.models.responses.EncodingResponse;
import com.carlosdv93.services.S3Service;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping(value="/converter")
public class Converter {
	
	@Autowired
	private S3Service s3Services;
	
	@GetMapping(produces="application/json")
	public HttpStatus converter() {
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ResponseEntity<String> uploadFile(@RequestParam(name="file") MultipartFile file) throws Exception {
		ResponseEntity<String> uri = uploadVideoFile(file);
		System.out.println(uri.getBody());
		return uri;
	}
	
	public ResponseEntity<String> uploadVideoFile(MultipartFile multipartFile) throws Exception {
		InputStream is = multipartFile.getInputStream();
		String contentType = multipartFile.getContentType();
		String fileName = multipartFile.getOriginalFilename();
		return s3Services.uploadFile(is, fileName, contentType);
	}
	
}
