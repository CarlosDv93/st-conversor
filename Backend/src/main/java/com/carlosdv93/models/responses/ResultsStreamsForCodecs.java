package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class ResultsStreamsForCodecs {
	private String id;
	private String createdAt;
	private String customDataCreatedAt;
	private String modifiedAt;
	ArrayList<Object> inputStreams = new ArrayList<Object>();
	private boolean createQualityMetaData;
	private String codecConfigId;
	private float segmentsEncoded;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getCustomDataCreatedAt() {
		return customDataCreatedAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public boolean getCreateQualityMetaData() {
		return createQualityMetaData;
	}

	public String getCodecConfigId() {
		return codecConfigId;
	}

	public float getSegmentsEncoded() {
		return segmentsEncoded;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setCustomDataCreatedAt(String customDataCreatedAt) {
		this.customDataCreatedAt = customDataCreatedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public void setCreateQualityMetaData(boolean createQualityMetaData) {
		this.createQualityMetaData = createQualityMetaData;
	}

	public void setCodecConfigId(String codecConfigId) {
		this.codecConfigId = codecConfigId;
	}

	public void setSegmentsEncoded(float segmentsEncoded) {
		this.segmentsEncoded = segmentsEncoded;
	}

}