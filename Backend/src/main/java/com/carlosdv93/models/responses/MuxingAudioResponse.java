package com.carlosdv93.models.responses;

public class MuxingAudioResponse {

	private String requestId;
	private String status;
	DataAudioMuxing DataObject;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public DataAudioMuxing getData() {
		return DataObject;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataAudioMuxing dataObject) {
		this.DataObject = dataObject;
	}
}