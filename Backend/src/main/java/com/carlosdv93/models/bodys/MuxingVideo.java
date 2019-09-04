package com.carlosdv93.models.bodys;

import java.io.Serializable;
import java.util.ArrayList;

public class MuxingVideo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float segmentLength = 4;
	private String segmentNaming = "seg_%number%.m4s";
	private String initSegmentName = "init.mp4";
	ArrayList<StreamMuxingVideo> streams = new ArrayList<StreamMuxingVideo>();
	ArrayList<OutputMuxingVideo> outputs = new ArrayList<OutputMuxingVideo>();

	// Getter Methods

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

	public void setSegmentLength(float segmentLength) {
		this.segmentLength = segmentLength;
	}

	public void setSegmentNaming(String segmentNaming) {
		this.segmentNaming = segmentNaming;
	}

	public void setInitSegmentName(String initSegmentName) {
		this.initSegmentName = initSegmentName;
	}
	
	public void setStreamId(String id) {
		StreamMuxingVideo stream = new StreamMuxingVideo();
		stream.setStreamId(id);
		streams.add(stream);
	}
	
	public void setOutPuts() {
		outputs.add(new OutputMuxingVideo());
	}

}

class StreamMuxingVideo {
	private String streamId;

	// Getter Methods

	public String getStreamId() {
		return streamId;
	}

	// Setter Methods

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
}

class OutputMuxingVideo {
	private String outputId = "OUTPUT_TESTE_1024";
	private String outputPath = "https://st-conversor-carlos9.s3-sa-east-1.amazonws.com/output/teste/h264/1024_1500000/fmp4/";
	ArrayList<AclPermission> acl = new ArrayList<AclPermission>();

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
	
	public void setAclPermission() {
		acl.add(new AclPermission());
	}
}

class AclPermission {
	private String permission = "PUBLIC_READ";

	// Getter Methods

	public String getPermission() {
		return permission;
	}

	// Setter Methods

	public void setPermission(String permission) {
		this.permission = permission;
	}
}