package com.carlosdv93.controller;

import java.net.URI;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.carlosdv93.models.bodys.StreamsForCodecs;
import com.carlosdv93.models.responses.StreamsForCodecsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateStreamsForCodecs {
	
	
	@SuppressWarnings("unchecked")
	public static ResponseEntity<StreamsForCodecsResponse> createStreamsForCodecsPOST(String encodingId, URI path, String codecConfigId) {
			
		HttpEntity<String> request;
		
		String urlBitmovin = "https://api.bitmovin.com/v1/encoding/encodings/"+encodingId+"/streams";
		StreamsForCodecs streams = new StreamsForCodecs();
		streams.setCodecConfigId(codecConfigId);
		streams.setInputStream(path.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(streams);
			System.out.println(json);
			
			HttpHeaders headers2 = new HttpHeaders();
	        headers2.setContentType(MediaType.APPLICATION_JSON);
	        headers2.add("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
	        headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        
			
	        HttpEntity<?> requestEntity = new HttpEntity(json, headers2);
	        ResponseEntity<StreamsForCodecsResponse> response = new RestTemplate().exchange(urlBitmovin, HttpMethod.POST, requestEntity, StreamsForCodecsResponse.class);
	        return response;
	        
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<StreamsForCodecsResponse>(HttpStatus.BAD_REQUEST);
		}

		
		
		/*
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");
        headers.add("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
        headers.add("Accept", "application/json");
        
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
        headers2.add("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
        headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        
		
        HttpEntity<StreamsForCodecs> requestEntity = new HttpEntity<>(streams, headers2);
        ResponseEntity<StreamsForCodecsResponse> response = new RestTemplate().exchange(urlBitmovin, HttpMethod.POST, requestEntity, StreamsForCodecsResponse.class);
        
		
		 * HttpEntity<StreamsForCodecs> requestEntity = new HttpEntity(streams,
		 * headers2); ResponseEntity<StreamsForCodecsResponse> response = new
		 * RestTemplate().exchange(urlBitmovin, HttpMethod.POST, requestEntity,
		 * StreamsForCodecsResponse.class); System.out.println(response.getBody());
		 
		return response;
		*/		
		
	}

}
