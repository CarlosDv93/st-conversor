package com.carlosdv93.models.bodys;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * {
  "codecConfigId": "2422e69b-55d6-4859-94c6-4df0df84709a", 
  "inputStreams": [{
    "inputId": "Input_Teste_1024_1",
    "inputPath": "https://st-bucket-carlosdv93.s3-sa-east-1.amazonws.com/input/sample_2.mkv",
    "selectionMode": "AUTO"
  }]
}
 */
public class StreamsForCodecs implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codecConfigId;
	ArrayList<InputStreamsCodec> inputStreams = new ArrayList<InputStreamsCodec>();

	// Getter Methods

	public String getCodecConfigId() {
		return codecConfigId;
	}

	// Setter Methods

	public void setCodecConfigId(String codecConfigId) {
		this.codecConfigId = codecConfigId;
	}
	
	public void setInputStream(String path) {
		InputStreamsCodec inputStreamsCodec = new InputStreamsCodec();
		inputStreamsCodec.setInputPath(path);
		inputStreams.add(inputStreamsCodec);
	}

}

class InputStreamsCodec {

	private String inputId = "Input_Teste_1024_1";
	private String inputPath;
	private String selectionMode = "AUTO";

	// Getter Methods

	public String getInputId() {
		return inputId;
	}

	public String getInputPath() {
		return inputPath;
	}

	public String getSelectionMode() {
		return selectionMode;
	}

	// Setter Methods

	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;
	}

}
