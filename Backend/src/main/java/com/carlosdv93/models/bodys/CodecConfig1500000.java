package com.carlosdv93.models.bodys;

import java.io.Serializable;

/*
 * {
	  "name": "Video Codec Config 1",
	  "bitrate": 1500000,
	  "width": 1024,
	  "profile": "HIGH"
	}
 */

public class CodecConfig1500000 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name = "Video Codec Config 1500000";
	public long bitrate = 1500000;
	public int width = 1024;
	public String profile = "HIGH";

	public CodecConfig1500000() {

	}

	public String getName() {
		return name;
	}

	public long getBitrate() {
		return bitrate;
	}

	public int getWidth() {
		return width;
	}

	public String getProfile() {
		return profile;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public void setBitrate(long bitrate) {
		this.bitrate = bitrate;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
