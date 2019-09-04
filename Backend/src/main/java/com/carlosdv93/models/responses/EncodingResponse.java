package com.carlosdv93.models.responses;

public class EncodingResponse {

	private String requestId;
	private String status;
	DataEncodingResponse DataObject;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public DataEncodingResponse getData() {
		return DataObject;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataEncodingResponse dataObject) {
		this.DataObject = dataObject;
	}
}