package com.carlosdv93.models.bodys;

import java.util.ArrayList;

public class EncodingStart {

	private String encodingMode = "SINGLE_PASS";
	ArrayList<PreviewDashManifest> previewDashManifests = new ArrayList<PreviewDashManifest>();
	ArrayList<VoidDashManifest> vodDashManifests = new ArrayList<VoidDashManifest>();

	// Getter Methods

	public EncodingStart(String manifestId) {
		PreviewDashManifest preview = new PreviewDashManifest();
		preview.setManifestId(manifestId);
		
		VoidDashManifest vod = new VoidDashManifest();
		vod.setManifestId(manifestId);
		
		previewDashManifests.add(preview);
		vodDashManifests.add(vod);
		
	}

	public String getEncodingMode() {
		return encodingMode;
	}

	// Setter Methods

	public ArrayList<PreviewDashManifest> getPreviewDashManifests() {
		return previewDashManifests;
	}

	public ArrayList<VoidDashManifest> getVodDashManifests() {
		return vodDashManifests;
	}

	public void setPreviewDashManifests(ArrayList<PreviewDashManifest> previewDashManifests) {
		this.previewDashManifests = previewDashManifests;
	}

	public void setVodDashManifests(ArrayList<VoidDashManifest> vodDashManifests) {
		this.vodDashManifests = vodDashManifests;
	}

	public void setEncodingMode(String encodingMode) {
		this.encodingMode = encodingMode;
	}

}

class PreviewDashManifest {
	private String manifestId;

	// Getter Methods

	public String getManifestId() {
		return manifestId;
	}

	// Setter Methods

	public void setManifestId(String manifestId) {
		this.manifestId = manifestId;
	}
}

class VoidDashManifest {
	private String manifestId;

	// Getter Methods

	public String getManifestId() {
		return manifestId;
	}

	// Setter Methods

	public void setManifestId(String manifestId) {
		this.manifestId = manifestId;
	}
}
