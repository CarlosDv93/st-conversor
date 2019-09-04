package com.carlosdv93.controller;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.carlosdv93.models.bodys.MuxingVideo;
import com.carlosdv93.models.responses.MuxingVideoResponse;

public class CreateMuxingVideo {

	@SuppressWarnings("rawtypes")
	public static ResponseEntity<MuxingVideoResponse> createMxVideoPOST(String id, String encodingId) {
				
		String urlBitmovin = "https://api.bitmovin.com/v1/encoding/encodings/"+encodingId+"/muxings/fmp4";
		MuxingVideo mxVideo = new MuxingVideo();
		mxVideo.setStreamId(id);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        map.put("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
        map.put("Accept", "application/json");
        
        headers.setAll(map);
		HttpEntity<String> request = new HttpEntity(mxVideo, headers);

        ResponseEntity<MuxingVideoResponse> response= new RestTemplate().exchange(urlBitmovin, HttpMethod.POST, request, MuxingVideoResponse.class);
		System.out.println(response.getBody());
		
		return response;
		
	}
	
}
