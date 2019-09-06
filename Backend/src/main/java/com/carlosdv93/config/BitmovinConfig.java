package com.carlosdv93.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.carlosdv93.controller.CreateCodecAudio;
import com.carlosdv93.controller.CreateCodecConfig1500000;
import com.carlosdv93.controller.CreateDashManifest;
import com.carlosdv93.controller.CreateEncoding;
import com.carlosdv93.controller.CreateMuxingAudio;
import com.carlosdv93.controller.CreateMuxingVideo;
import com.carlosdv93.controller.CreateOutputS3;
import com.carlosdv93.controller.CreateStreamsForCodecs;
import com.carlosdv93.controller.StartEncoding;
import com.carlosdv93.models.responses.AudioCodecResponse;
import com.carlosdv93.models.responses.CodecConfig1500000Response;
import com.carlosdv93.models.responses.DashManifestResponse;
import com.carlosdv93.models.responses.EncodingResponse;
import com.carlosdv93.models.responses.MuxingAudioResponse;
import com.carlosdv93.models.responses.MuxingVideoResponse;
import com.carlosdv93.models.responses.OutputS3Response;
import com.carlosdv93.models.responses.ResponseStart;
import com.carlosdv93.models.responses.StreamsForCodecsResponse;
import com.carlosdv93.services.S3Service;

public class BitmovinConfig {

	private static Logger log = org.slf4j.LoggerFactory.getLogger(BitmovinConfig.class);

	public BitmovinConfig() {
	}

	public ResponseEntity<String> converter(URI path, S3Credential s3Creds) throws URISyntaxException {
		
		//Criando o encoding
		ResponseEntity<EncodingResponse> response = CreateEncoding.createEncodingPOST();
		System.out.println("encodingId: "+response.getBody().getData().getResult().getId());
		String encodingId = response.getBody().getData().getResult().getId();
		
		//Criando o Codec 1500000
		ResponseEntity<CodecConfig1500000Response> responseCodecConfig = CreateCodecConfig1500000.createCodecConfig1500000POST();
		
		System.out.println("codecConfigId: " + responseCodecConfig.getBody().getData().getResult().getId());
		String codecConfigId = responseCodecConfig.getBody().getData().getResult().getId();
		
		//Criando a stream
		ResponseEntity<StreamsForCodecsResponse> responseStreamsForCodecs = CreateStreamsForCodecs.createStreamsForCodecsPOST(encodingId, path, codecConfigId);
		System.out.println("streamId " + responseStreamsForCodecs.getBody().getData().getResult().getId());
		String streamId = responseStreamsForCodecs.getBody().getData().getResult().getId();

		//Criando o codec de Audio
		ResponseEntity<AudioCodecResponse> responseAudioCodec = CreateCodecAudio.createAudioCodecPOST();
		System.out.println("idAudioCodec: " + responseAudioCodec.getBody().getData().getResult().getId());
		String idAudioCodec = responseAudioCodec.getBody().getData().getResult().getId();
		
		//Criando Muxing Video
		ResponseEntity<MuxingVideoResponse> responseMxVideo = CreateMuxingVideo.createMxVideoPOST(streamId, encodingId);
		System.out.println("mxVideoId: " + responseMxVideo.getBody().getData().getResult().getId());
		String mxVideoId = responseMxVideo.getBody().getData().getResult().getId();
		
		//Criando Muxing Audio
		ResponseEntity<MuxingAudioResponse> responseMxAudio = CreateMuxingAudio.createMxAudioPOST(streamId, encodingId);
		System.out.println("mxAudioId: " + responseMxAudio.getBody().getData().getResult().getId());
		String mxAudioId = responseMxAudio.getBody().getData().getResult().getId();
		
		//Criando o DashManifest
		ResponseEntity<DashManifestResponse> responseDash = CreateDashManifest.createDashManifestPOST();
		String manifestName = responseDash.getBody().getData().getResult().getManifestName();
		String manifestId = responseDash.getBody().getData().getResult().getId();
		String outputPathManifest = responseDash.getBody().getData().getResult().getOutputs().get(0).getOutputPath();
		log.info("MANIFEST PATH: " + outputPathManifest +"/"+ manifestName);
		
		//Criando Output
		ResponseEntity<OutputS3Response> outputS3 = CreateOutputS3.createOutPutS3POST(s3Creds);
		String outputS3Id = outputS3.getBody().getData().getResult().getId();
		log.info(outputS3Id);
		
		//Startando o encoding
		ResponseEntity<ResponseStart> responseStart = StartEncoding.startEncodingPOST(encodingId, manifestId);
		String startEncodingId = responseStart.getBody().getId();
		log.info("Encoding do Start: " + startEncodingId);
		
		String uri = new URI(outputPathManifest +"/"+ manifestName).toString();
		
		ResponseEntity<String> retorno = new ResponseEntity<String>(uri, HttpStatus.CREATED);
		
		return retorno;
	}

}
