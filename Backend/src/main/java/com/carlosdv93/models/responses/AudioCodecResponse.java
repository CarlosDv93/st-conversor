package com.carlosdv93.models.responses;

public class AudioCodecResponse {

	private String requestId;
	private String status;
	DataAudioCodec DataObject;

	// Getter Methods

	public String getRequestId() {
		return requestId;
	}

	public String getStatus() {
		return status;
	}

	public DataAudioCodec getData() {
		return DataObject;
	}

	// Setter Methods

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(DataAudioCodec dataObject) {
		this.DataObject = dataObject;
	}
}
