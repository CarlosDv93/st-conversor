package com.carlosdv93.models.bodys;

import java.io.Serializable;

public class AudioCodec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name = "Audio Codec Config";
	private float bitrate = 128000;

	// Getter Methods

	public String getName() {
		return name;
	}

	public float getBitrate() {
		return bitrate;
	}

	// Setter Methods

	public void setName(String name) {
		this.name = name;
	}

	public void setBitrate(float bitrate) {
		this.bitrate = bitrate;
	}

}
