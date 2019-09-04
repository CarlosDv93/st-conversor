package com.carlosdv93.models.bodys;

import java.io.Serializable;

import com.bitmovin.api.encoding.enums.CloudRegion;

/**
 * 
 * { "name":"Encoding UI", "cloudRegion":"AWS_SA_EAST_1",
 * "encoderVersion":"2.22.0" }
 *
 */

public class Encoding implements Serializable {

	private static final long serialVersionUID = 1L;

	public String name = "Encoding UI";
	public CloudRegion cloudRegion = CloudRegion.AWS_SA_EAST_1;
	public String encoderVersion = "2.22.0";

	public Encoding() {
	}

	public String getName() {
		return name;
	}

	public CloudRegion getCloudRegion() {
		return cloudRegion;
	}

	public String getEncoderVersion() {
		return encoderVersion;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCloudRegion(CloudRegion cloudRegion) {
		this.cloudRegion = cloudRegion;
	}

	public void setEncoderVersion(String encoderVersion) {
		this.encoderVersion = encoderVersion;
	}

	public Object toJson() {
		return "'{" + "'name': '" + getName() + "'\n" + "'cloudRegion': '" + getCloudRegion() + "'\n"
				+ "'encoderVersion: '" + getEncoderVersion() + "'\n" + "}'";
	}

}
