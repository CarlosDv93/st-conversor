package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataAudioCodec {
	ResultAudioCodec ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultAudioCodec getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultAudioCodec resultObject) {
		this.ResultObject = resultObject;
	}
}