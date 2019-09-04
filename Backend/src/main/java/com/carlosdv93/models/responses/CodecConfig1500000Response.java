package com.carlosdv93.models.responses;

public class CodecConfig1500000Response {

	private String requestId;
	private String status;
	DataCodecConfig1500000 DataObject;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public DataCodecConfig1500000 getData() {
		return DataObject;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataCodecConfig1500000 dataObject) {
		this.DataObject = dataObject;
	}
}