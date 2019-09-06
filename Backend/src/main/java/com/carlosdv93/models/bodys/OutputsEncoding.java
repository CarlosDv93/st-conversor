package com.carlosdv93.models.bodys;

import org.springframework.context.annotation.PropertySource;

public class OutputsEncoding {

	private String name;
	private String bucketName;
	private String accessKey;
	private String secretKey;

	public OutputsEncoding() {
	}

	// Getter Methods

	public String getName() {
		return name;
	}

	public String getBucketName() {
		return bucketName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	// Setter Methods

	public void setName(String name) {
		this.name = name;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
