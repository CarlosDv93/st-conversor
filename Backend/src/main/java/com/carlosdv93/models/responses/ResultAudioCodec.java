package com.carlosdv93.models.responses;

public class ResultAudioCodec {
	private String id;
	private String name;
	private String createdAt;
	private String modifiedAt;
	private float bitrate;
	private String channelLayout;

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

	public float getBitrate() {
		return bitrate;
	}

	public String getChannelLayout() {
		return channelLayout;
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

	public void setBitrate(float bitrate) {
		this.bitrate = bitrate;
	}

	public void setChannelLayout(String channelLayout) {
		this.channelLayout = channelLayout;
	}

}
