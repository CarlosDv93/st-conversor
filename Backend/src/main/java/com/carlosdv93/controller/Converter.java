package com.carlosdv93.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carlosdv93.services.S3Service;

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
	public ResponseEntity<Void> uploadPicture(@RequestParam(name="file") MultipartFile file) throws URISyntaxException, IOException{
		URI uri = uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) throws URISyntaxException, IOException {
		
		InputStream is = multipartFile.getInputStream();
		String contentType = multipartFile.getContentType();
		String fileName = multipartFile.getName();
		
		return s3Services.uploadFile(is, fileName, contentType);
	}
	
}
