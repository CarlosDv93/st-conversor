package com.carlosdv93.models.responses;

public class MuxingVideoResponse {

	private String requestId;
	private String status;
	DataMuxingVideo DataObject;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public DataMuxingVideo getData() {
		return DataObject;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataMuxingVideo dataObject) {
		this.DataObject = dataObject;
	}
}
