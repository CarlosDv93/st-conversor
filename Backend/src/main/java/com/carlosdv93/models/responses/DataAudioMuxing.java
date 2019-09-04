package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataAudioMuxing {
	ResultAudioMuxing ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultAudioMuxing getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultAudioMuxing resultObject) {
		this.ResultObject = resultObject;
	}
}