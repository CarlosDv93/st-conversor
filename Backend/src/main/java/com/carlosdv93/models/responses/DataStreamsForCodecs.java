package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataStreamsForCodecs {
	ResultsStreamsForCodecs ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultsStreamsForCodecs getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultsStreamsForCodecs resultObject) {
		this.ResultObject = resultObject;
	}
}