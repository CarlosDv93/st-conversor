package com.carlosdv93.config;

public class S3Credential {

	private String accessKey;
	private String secretKey;
	private String bucketName;
	
	public S3Credential() {
		super();
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	
	
	
}
