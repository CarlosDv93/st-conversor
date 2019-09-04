package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class ResultMuxingVideo {
	private String id;
	ArrayList<Object> streams = new ArrayList<Object>();
	ArrayList<Object> outputs = new ArrayList<Object>();
	private String streamConditionsMode;
	private float segmentLength;
	private String segmentNaming;
	private String initSegmentName;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getStreamConditionsMode() {
		return streamConditionsMode;
	}

	public float getSegmentLength() {
		return segmentLength;
	}

	public String getSegmentNaming() {
		return segmentNaming;
	}

	public String getInitSegmentName() {
		return initSegmentName;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setStreamConditionsMode(String streamConditionsMode) {
		this.streamConditionsMode = streamConditionsMode;
	}

	public void setSegmentLength(float segmentLength) {
		this.segmentLength = segmentLength;
	}

	public void setSegmentNaming(String segmentNaming) {
		this.segmentNaming = segmentNaming;
	}

	public void setInitSegmentName(String initSegmentName) {
		this.initSegmentName = initSegmentName;
	}

}