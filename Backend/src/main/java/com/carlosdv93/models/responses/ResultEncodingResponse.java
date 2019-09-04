package com.carlosdv93.models.responses;

public class ResultEncodingResponse {
	private String id;
	private String name;
	private String encoderVersion;
	private String createdAt;
	private String modifiedAt;
	private String cloudRegion;
	private String selectedCloudRegion;
	private String type;
	private String status;
	private float progress;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEncoderVersion() {
		return encoderVersion;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public String getCloudRegion() {
		return cloudRegion;
	}

	public String getSelectedCloudRegion() {
		return selectedCloudRegion;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public float getProgress() {
		return progress;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEncoderVersion(String encoderVersion) {
		this.encoderVersion = encoderVersion;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public void setCloudRegion(String cloudRegion) {
		this.cloudRegion = cloudRegion;
	}

	public void setSelectedCloudRegion(String selectedCloudRegion) {
		this.selectedCloudRegion = selectedCloudRegion;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}
}

