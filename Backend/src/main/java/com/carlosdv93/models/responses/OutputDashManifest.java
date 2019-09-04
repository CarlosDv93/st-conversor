package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class OutputDashManifest {
	private String outputId;
	private String outputPath;
	ArrayList<Object> acl = new ArrayList<Object>();

	// Getter Methods

	public String getOutputId() {
		return outputId;
	}

	public String getOutputPath() {
		return outputPath;
	}

	// Setter Methods

	public void setOutputId(String outputId) {
		this.outputId = outputId;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
}