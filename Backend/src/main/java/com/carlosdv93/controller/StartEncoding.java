package com.carlosdv93.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.carlosdv93.models.bodys.EncodingStart;
import com.carlosdv93.models.responses.ResponseStart;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StartEncoding {

	@SuppressWarnings("unchecked")
	public static ResponseEntity<ResponseStart> startEncodingPOST(String encodingId, String manifestId) {
			
		HttpEntity<String> request;
		
		String urlBitmovin = "https://api.bitmovin.com/v1/encoding/encodings/"+encodingId+"/streams";
		EncodingStart start = new EncodingStart(manifestId);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(start);
			System.out.println("Start Encoding: " + json);
			
			HttpHeaders headers2 = new HttpHeaders();
	        headers2.setContentType(MediaType.APPLICATION_JSON);
	        headers2.add("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
	        headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        
			
	        HttpEntity<?> requestEntity = new HttpEntity(json, headers2);
	        ResponseEntity<ResponseStart> response = new RestTemplate().exchange(urlBitmovin, HttpMethod.POST, requestEntity, ResponseStart.class);
	        return response;
	        
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<ResponseStart>(HttpStatus.BAD_REQUEST);
		}

	}
}
