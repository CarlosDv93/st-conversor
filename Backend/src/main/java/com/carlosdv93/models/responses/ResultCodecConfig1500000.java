package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class ResultCodecConfig1500000 {
	private String id;
	private String name;
	private String createdAt;
	private String modifiedAt;
	private float bitrate;
	private float width;
	private String profile;
	private float bframes;
	private float refFrames;
	private String mvPredictionMode;
	private float mvSearchRangeMax;
	private boolean cabac;
	private String bAdaptiveStrategy;
	private String motionEstimationMethod;
	private float rcLookahead;
	private String subMe;
	ArrayList<Object> partitions = new ArrayList<Object>();
	private String trellis;
	private String nalHrd;
	private String bPyramid;

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

	public float getWidth() {
		return width;
	}

	public String getProfile() {
		return profile;
	}

	public float getBframes() {
		return bframes;
	}

	public float getRefFrames() {
		return refFrames;
	}

	public String getMvPredictionMode() {
		return mvPredictionMode;
	}

	public float getMvSearchRangeMax() {
		return mvSearchRangeMax;
	}

	public boolean getCabac() {
		return cabac;
	}

	public String getBAdaptiveStrategy() {
		return bAdaptiveStrategy;
	}

	public String getMotionEstimationMethod() {
		return motionEstimationMethod;
	}

	public float getRcLookahead() {
		return rcLookahead;
	}

	public String getSubMe() {
		return subMe;
	}

	public String getTrellis() {
		return trellis;
	}

	public String getNalHrd() {
		return nalHrd;
	}

	public String getBPyramid() {
		return bPyramid;
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

	public void setWidth(float width) {
		this.width = width;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setBframes(float bframes) {
		this.bframes = bframes;
	}

	public void setRefFrames(float refFrames) {
		this.refFrames = refFrames;
	}

	public void setMvPredictionMode(String mvPredictionMode) {
		this.mvPredictionMode = mvPredictionMode;
	}

	public void setMvSearchRangeMax(float mvSearchRangeMax) {
		this.mvSearchRangeMax = mvSearchRangeMax;
	}

	public void setCabac(boolean cabac) {
		this.cabac = cabac;
	}

	public void setBAdaptiveStrategy(String bAdaptiveStrategy) {
		this.bAdaptiveStrategy = bAdaptiveStrategy;
	}

	public void setMotionEstimationMethod(String motionEstimationMethod) {
		this.motionEstimationMethod = motionEstimationMethod;
	}

	public void setRcLookahead(float rcLookahead) {
		this.rcLookahead = rcLookahead;
	}

	public void setSubMe(String subMe) {
		this.subMe = subMe;
	}

	public void setTrellis(String trellis) {
		this.trellis = trellis;
	}

	public void setNalHrd(String nalHrd) {
		this.nalHrd = nalHrd;
	}

	public void setBPyramid(String bPyramid) {
		this.bPyramid = bPyramid;
	}

}
