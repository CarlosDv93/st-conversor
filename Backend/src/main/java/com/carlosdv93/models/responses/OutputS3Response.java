package com.carlosdv93.models.responses;

public class OutputS3Response {

	private String requestId;
	private String status;
	DataOutputS3 data;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public DataOutputS3 getDataObject() {
		return data;
	}

	public void setDataObject(DataOutputS3 dataObject) {
		data = dataObject;
	}

	public String getStatus() {
		return status;
	}

	public DataOutputS3 getData() {
		return data;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataOutputS3 dataObject) {
		this.data = dataObject;
	}
}