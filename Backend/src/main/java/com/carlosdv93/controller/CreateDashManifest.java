package com.carlosdv93.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.carlosdv93.models.bodys.DashManifest;
import com.carlosdv93.models.responses.DashManifestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateDashManifest {
	
	
	@SuppressWarnings("rawtypes")
	public static ResponseEntity<DashManifestResponse> createDashManifestPOST() {
				
		String urlBitmovin = "https://api.bitmovin.com/v1/encoding/manifests/dash";
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			DashManifest dash = new DashManifest();
			dash.setOutputs();
			String json = mapper.writeValueAsString(dash);
			System.out.println("DASH" + json);
			
			HttpHeaders headers2 = new HttpHeaders();
	        headers2.setContentType(MediaType.APPLICATION_JSON);
	        headers2.add("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
	        headers2.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        
			
	        HttpEntity<?> requestEntity = new HttpEntity(json, headers2);
	        ResponseEntity<DashManifestResponse> response = new RestTemplate().exchange(urlBitmovin, HttpMethod.POST, requestEntity, DashManifestResponse.class);
	        System.out.println(response.getBody());
	        return response;
	        
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<DashManifestResponse>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
