package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataCodecConfig1500000 {
	ResultCodecConfig1500000 ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultCodecConfig1500000 getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultCodecConfig1500000 resultObject) {
		this.ResultObject = resultObject;
	}
}