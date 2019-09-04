package com.carlosdv93.controller;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.carlosdv93.models.bodys.CodecConfig1500000;
import com.carlosdv93.models.responses.CodecConfig1500000Response;

public class CreateCodecConfig1500000 {

	private static String urlBitmovin = "https://api.bitmovin.com/v1/encoding/encodings";

	public static ResponseEntity<CodecConfig1500000Response> createCodecConfig1500000POST() {
		
		CodecConfig1500000 codecConfig = new CodecConfig1500000();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		map.put("x-api-key", "118065dc-faf8-47d2-ba7c-daa8a284f1ac");
		map.put("Accept", "application/json");

		headers.setAll(map);
		HttpEntity<String> request = new HttpEntity(codecConfig, headers);

		ResponseEntity<CodecConfig1500000Response> responseCodec = new RestTemplate().postForEntity(urlBitmovin, request, CodecConfig1500000Response.class);
		System.out.println(responseCodec.getBody());

		return responseCodec;

	}

}
