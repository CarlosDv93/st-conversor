package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataEncodingResponse {
	ResultEncodingResponse ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultEncodingResponse getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultEncodingResponse resultObject) {
		this.ResultObject = resultObject;
	}
}