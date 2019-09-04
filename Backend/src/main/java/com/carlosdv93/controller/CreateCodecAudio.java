package com.carlosdv93.controller;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.carlosdv93.models.bodys.AudioCodec;
import com.carlosdv93.models.responses.AudioCodecResponse;

public class CreateCodecAudio {
	@SuppressWarnings("rawtypes")
	public static ResponseEntity<AudioCodecResponse> createAudioCodecPOST() {
				
		String urlBitmovin = "https://api.bitmovin.com/v1/encoding/configurations/audio/aac";
		AudioCodec audio = new AudioCodec();
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
        map.put("Accept", "application/json");
        
        headers.setAll(map);
		HttpEntity<String> request = new HttpEntity(audio, headers);

        ResponseEntity<AudioCodecResponse> response= new RestTemplate().exchange(urlBitmovin, HttpMethod.POST, request, AudioCodecResponse.class);
		System.out.println(response.getBody());
		
		return response;
		
	}
}
