package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataOutputS3 {
	ResultOutputS3 ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultOutputS3 getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultOutputS3 resultObject) {
		this.ResultObject = resultObject;
	}
}