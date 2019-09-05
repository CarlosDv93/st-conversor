package com.carlosdv93.models.bodys;

import java.io.Serializable;
import java.util.ArrayList;

public class DashManifest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name = "Manifest";
	private String manifestName = "manifest.mpd";
	ArrayList<Outputs> outputs = new ArrayList<Outputs>();

	// Getter Methods

	public String getName() {
		return name;
	}

	public String getManifestName() {
		return manifestName;
	}

	// Setter Methods

	public void setName(String name) {
		this.name = name;
	}

	public void setManifestName(String manifestName) {
		this.manifestName = manifestName;
	}

	public ArrayList<Outputs> getOutputs() {
		return outputs;
	}

	public void setOutputs(ArrayList<Outputs> outputsObject) {
		outputs = outputsObject;
	}
	
	public void setOutputs() {
		Outputs output = new Outputs();
		outputs.add(output);
	}

}

class Outputs {
	private String outputId = "Manifest_TESTE_1024";
	private String outputPath = "https://st-conversor-carlos9.s3-sa-east-1.amazonws.com/output/teste/mpd/";
	ArrayList<AclPermissionDash> acl = new ArrayList<AclPermissionDash>();

	// Getter Methods

	public String getOutputId() {
		return outputId;
	}

	public String getOutputPath() {
		return outputPath;
	}

	// Setter Methods

	public ArrayList<AclPermissionDash> getAcl() {
		return acl;
	}

	public void setAcl(ArrayList<AclPermissionDash> acl) {
		this.acl = acl;
	}

	public void setOutputId(String outputId) {
		this.outputId = outputId;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	public void setAclPermission() {
		acl.add(new AclPermissionDash());
	}
}

class AclPermissionDash {
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
