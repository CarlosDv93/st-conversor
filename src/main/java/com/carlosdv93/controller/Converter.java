package com.carlosdv93.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/converter")
public class Converter {
	
	@GetMapping(produces="application/json")
	public HttpStatus converter() {
		return HttpStatus.OK;
	}
	
}
