package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class DataDashManifest {
	ResultDashManifest ResultObject;
	ArrayList<Object> messages = new ArrayList<Object>();

	// Getter Methods

	public ResultDashManifest getResult() {
		return ResultObject;
	}

	// Setter Methods

	public void setResult(ResultDashManifest resultObject) {
		this.ResultObject = resultObject;
	}
}
