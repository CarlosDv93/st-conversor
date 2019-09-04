package com.carlosdv93.models.responses;

public class StreamsForCodecsResponse {

	private String requestId;
	private String status;
	DataStreamsForCodecs DataObject;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public DataStreamsForCodecs getData() {
		return DataObject;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataStreamsForCodecs dataObject) {
		this.DataObject = dataObject;
	}
}