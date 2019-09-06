package com.carlosdv93.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.carlosdv93.config.S3Credential;
import com.carlosdv93.models.bodys.OutputsEncoding;
import com.carlosdv93.models.responses.OutputS3Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateOutputS3 {

	private String name = "Outputs";
	
	public CreateOutputS3() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public static ResponseEntity<OutputS3Response> createOutPutS3POST(S3Credential s3Cred) {
		
		String urlBitmovin = "https://api.bitmovin.com/v1/encoding/outputs/s3";
		OutputsEncoding output = new OutputsEncoding(); 
		output.setAccessKey(s3Cred.getAccessKey());
		output.setBucketName(s3Cred.getBucketName());
		output.setName("OutputS3");
		output.setSecretKey(s3Cred.getSecretKey());
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(output);
			System.out.println("S3 Output: " + json);
			
			HttpHeaders headers2 = new HttpHeaders();
	        headers2.setContentType(MediaType.APPLICATION_JSON);
	        headers2.add("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
	        headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        
	        HttpEntity<?> requestEntity = new HttpEntity(json, headers2);
	        ResponseEntity<OutputS3Response> response = new RestTemplate().exchange(urlBitmovin, HttpMethod.POST, requestEntity, OutputS3Response.class);
	        return response;
	        
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<OutputS3Response>(HttpStatus.BAD_REQUEST);
		}

	}
}
