package com.carlosdv93.models.responses;

public class ResultOutputS3 {
	private String id;
	private String name;
	private String createdAt;
	private String modifiedAt;
	private String type;
	private String bucketName;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public String getType() {
		return type;
	}

	public String getBucketName() {
		return bucketName;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

}
