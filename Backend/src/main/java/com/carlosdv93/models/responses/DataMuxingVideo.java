package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataMuxingVideo {
	ResultMuxingVideo ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultMuxingVideo getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultMuxingVideo resultObject) {
		this.ResultObject = resultObject;
	}
}