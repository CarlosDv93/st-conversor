package com.carlosdv93.models.responses;

public class DashManifestResponse {
	private String requestId;
	private String status;
	DataDashManifest DataObject;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public DataDashManifest getData() {
		return DataObject;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataDashManifest dataObject) {
		this.DataObject = dataObject;
	}
}