package com.carlosdv93.models.responses;

import java.util.ArrayList;

public class ResultDashManifest {
	private String id;
	private String createdAt;
	private String modifiedAt;
	private String type;
	private String name;
	private String description = null;
	private String status;
	private String manifestName;
	private String profile;
	ArrayList<OutputDashManifest> outputs = new ArrayList<OutputDashManifest>();
	private String namespaces = null;
	private String utcTimings = null;

	// Getter Methods

	public String getId() {
		return id;
	}

	public ArrayList<OutputDashManifest> getOutputs() {
		return outputs;
	}

	public void setOutputs(ArrayList<OutputDashManifest> outputs) {
		this.outputs = outputs;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public String getManifestName() {
		return manifestName;
	}

	public String getProfile() {
		return profile;
	}

	public String getNamespaces() {
		return namespaces;
	}

	public String getUtcTimings() {
		return utcTimings;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setManifestName(String manifestName) {
		this.manifestName = manifestName;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setNamespaces(String namespaces) {
		this.namespaces = namespaces;
	}

	public void setUtcTimings(String utcTimings) {
		this.utcTimings = utcTimings;
	}

}
