package com.carlosdv93.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

import com.bitmovin.api.BitmovinApi;
import com.carlosdv93.controller.CreateCodecAudio;
import com.carlosdv93.controller.CreateCodecConfig1500000;
import com.carlosdv93.controller.CreateDashManifest;
import com.carlosdv93.controller.CreateEncoding;
import com.carlosdv93.controller.CreateMuxingAudio;
import com.carlosdv93.controller.CreateMuxingVideo;
import com.carlosdv93.controller.CreateStreamsForCodecs;
import com.carlosdv93.models.responses.AudioCodecResponse;
import com.carlosdv93.models.responses.CodecConfig1500000Response;
import com.carlosdv93.models.responses.DashManifestResponse;
import com.carlosdv93.models.responses.EncodingResponse;
import com.carlosdv93.models.responses.MuxingAudioResponse;
import com.carlosdv93.models.responses.MuxingVideoResponse;
import com.carlosdv93.models.responses.StreamsForCodecsResponse;

@PropertySource("aws.config.properties")
public class BitmovinConfig {

	@Value("${bitmovin.config.api}")
	private String apiBitmovin;

	@Value("${aws.access_key_id}")
	private String awsAccessKey;

	@Value("${aws.secret_access_key}")
	private String awsSecretKey;

	@Value("${s3.bucket}")
	private String s3BucketName;

	@Value("${s3.region}")
	private String s3Region;

	private static Logger log = org.slf4j.LoggerFactory.getLogger(BitmovinConfig.class);

	private static BitmovinApi bitmovin;

	public BitmovinConfig() {
	}

	public BodyBuilder converter(URI path) throws URISyntaxException {

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
		String outputPathManifest = responseDash.getBody().getData().getResult().getOutputs().get(0).getOutputPath();
		log.info("MANIFEST PATH: " + outputPathManifest +"/"+ manifestName);
		URI uri = new URI(outputPathManifest +"/"+ manifestName);
		
		return ResponseEntity.created(uri);
	}


	/*
	 * public DashManifest converter(String nome, URL path) throws IOException,
	 * BitmovinApiException, UnirestException, URISyntaxException, RestException,
	 * InterruptedException { //bitmovin = new BitmovinApi(apiBitmovin); bitmovin =
	 * new BitmovinApi("118065dc-faf8-47d2-ba7c-daa8a284f1ac");
	 * 
	 * log.info("Path: " + path);
	 * 
	 * // create the input
	 * 
	 * HttpsInput input = new HttpsInput();
	 * input.setHost("https://st-bucket-carlosdv93.s3-sa-east-1.amazonaws.com/");
	 * input = bitmovin.input.https.create(input);
	 * 
	 * 
	 * S3Input input = new S3Input(); input.setName("Convertendo: " + nome);
	 * 
	 * input.setAccessKey(awsAccessKey); input.setSecretKey(awsSecretKey);
	 * input.setBucketName(s3BucketName+"/input");
	 * 
	 * 
	 * input.setAccessKey("AKIAR6N3MDTTNZIBB6UT");
	 * input.setSecretKey("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");
	 * input.setBucketName("st-bucket-carlosdv93");
	 * 
	 * input = bitmovin.input.s3.create(input);
	 * 
	 * // create the output S3Output output = new S3Output();
	 * 
	 * 
	 * output.setAccessKey(awsAccessKey); output.setSecretKey(awsSecretKey);
	 * output.setBucketName(s3BucketName+"/output");
	 * 
	 * 
	 * output.setAccessKey("AKIAR6N3MDTTNZIBB6UT");
	 * output.setSecretKey("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");
	 * output.setBucketName("st-bucket-carlosdv93");
	 * 
	 * output = bitmovin.output.s3.create(output); String outputId = output.getId();
	 * 
	 * // create the video and audio codec configurations H264VideoConfiguration
	 * videoCodecConfig1 = new H264VideoConfiguration();
	 * 
	 * videoCodecConfig1.setName(nome + " Getting Started H264 Codec Config 1");
	 * videoCodecConfig1.setBitrate(240000L); videoCodecConfig1.setWidth(384);
	 * videoCodecConfig1.setProfile(ProfileH264.HIGH);
	 * 
	 * videoCodecConfig1 =
	 * bitmovin.configuration.videoH264.create(videoCodecConfig1);
	 * 
	 * H264VideoConfiguration videoCodecConfig2 = new H264VideoConfiguration();
	 * 
	 * videoCodecConfig2.setName(nome + " Getting Started H264 Codec Config 2");
	 * videoCodecConfig2.setBitrate(375000L); videoCodecConfig2.setWidth(384);
	 * videoCodecConfig2.setProfile(ProfileH264.HIGH);
	 * 
	 * videoCodecConfig2 =
	 * bitmovin.configuration.videoH264.create(videoCodecConfig2);
	 * 
	 * H264VideoConfiguration videoCodecConfig3 = new H264VideoConfiguration();
	 * 
	 * videoCodecConfig3.setName(nome + " Getting Started H264 Codec Config 3");
	 * videoCodecConfig3.setBitrate(550000L); videoCodecConfig3.setWidth(512);
	 * videoCodecConfig3.setProfile(ProfileH264.HIGH);
	 * 
	 * videoCodecConfig3 =
	 * bitmovin.configuration.videoH264.create(videoCodecConfig3);
	 * 
	 * H264VideoConfiguration videoCodecConfig4 = new H264VideoConfiguration();
	 * 
	 * videoCodecConfig4.setName(nome + " Getting Started H264 Codec Config 4");
	 * videoCodecConfig4.setBitrate(750000L); videoCodecConfig4.setWidth(640);
	 * videoCodecConfig4.setProfile(ProfileH264.HIGH);
	 * 
	 * videoCodecConfig4 =
	 * bitmovin.configuration.videoH264.create(videoCodecConfig4);
	 * 
	 * H264VideoConfiguration videoCodecConfig5 = new H264VideoConfiguration();
	 * 
	 * videoCodecConfig5.setName(nome + " Getting Started H264 Codec Config 5");
	 * videoCodecConfig5.setBitrate(1000000L); videoCodecConfig5.setWidth(768);
	 * videoCodecConfig5.setProfile(ProfileH264.HIGH);
	 * 
	 * videoCodecConfig5 =
	 * bitmovin.configuration.videoH264.create(videoCodecConfig5);
	 * 
	 * H264VideoConfiguration videoCodecConfig6 = new H264VideoConfiguration();
	 * 
	 * videoCodecConfig6.setName(nome + " Getting Started H264 Codec Config 6");
	 * videoCodecConfig6.setBitrate(1500000L); videoCodecConfig6.setWidth(1024);
	 * videoCodecConfig6.setProfile(ProfileH264.HIGH);
	 * 
	 * videoCodecConfig6 =
	 * bitmovin.configuration.videoH264.create(videoCodecConfig6);
	 * 
	 * AACAudioConfig audioCodecConfig = new AACAudioConfig();
	 * 
	 * audioCodecConfig.setName(nome + " Getting Started Audio Codec Config");
	 * audioCodecConfig.setBitrate(128000L);
	 * 
	 * audioCodecConfig = bitmovin.configuration.audioAAC.create(audioCodecConfig);
	 * 
	 * // create the encoding resource Encoding encoding = new Encoding();
	 * 
	 * encoding.setName(nome + " Getting Started Encoding");
	 * encoding.setCloudRegion(CloudRegion.AWS_SA_EAST_1);
	 * encoding.setEncoderVersion("2.22.0");
	 * 
	 * encoding = bitmovin.encoding.create(encoding);
	 * 
	 * // add the video and audio streams to the encoding // String inputPath1 =
	 * "/bitmovin-sample-content/tears_of_steel_1080p.mov"; String inputPath =
	 * "input/" + nome; // String inputPath = path;
	 * 
	 * Stream streamVideo1 = new Stream();
	 * 
	 * InputStream inputStreamVideo1 = new InputStream();
	 * inputStreamVideo1.setInputId(input.getId());
	 * inputStreamVideo1.setInputPath(inputPath);
	 * inputStreamVideo1.setSelectionMode(StreamSelectionMode.AUTO);
	 * 
	 * streamVideo1.setCodecConfigId(videoCodecConfig1.getId());
	 * streamVideo1.addInputStream(inputStreamVideo1);
	 * 
	 * streamVideo1 = bitmovin.encoding.stream.addStream(encoding, streamVideo1);
	 * 
	 * Stream streamVideo2 = new Stream();
	 * 
	 * InputStream inputStreamVideo2 = new InputStream();
	 * inputStreamVideo2.setInputId(input.getId());
	 * inputStreamVideo2.setInputPath(inputPath);
	 * inputStreamVideo2.setSelectionMode(StreamSelectionMode.AUTO);
	 * 
	 * streamVideo2.setCodecConfigId(videoCodecConfig2.getId());
	 * streamVideo2.addInputStream(inputStreamVideo2);
	 * 
	 * streamVideo2 = bitmovin.encoding.stream.addStream(encoding, streamVideo2);
	 * 
	 * Stream streamVideo3 = new Stream();
	 * 
	 * InputStream inputStreamVideo3 = new InputStream();
	 * inputStreamVideo3.setInputId(input.getId());
	 * inputStreamVideo3.setInputPath(inputPath);
	 * inputStreamVideo3.setSelectionMode(StreamSelectionMode.AUTO);
	 * 
	 * streamVideo3.setCodecConfigId(videoCodecConfig3.getId());
	 * streamVideo3.addInputStream(inputStreamVideo3);
	 * 
	 * streamVideo3 = bitmovin.encoding.stream.addStream(encoding, streamVideo3);
	 * 
	 * Stream streamVideo4 = new Stream();
	 * 
	 * InputStream inputStreamVideo4 = new InputStream();
	 * inputStreamVideo4.setInputId(input.getId());
	 * inputStreamVideo4.setInputPath(inputPath);
	 * inputStreamVideo4.setSelectionMode(StreamSelectionMode.AUTO);
	 * 
	 * streamVideo4.setCodecConfigId(videoCodecConfig4.getId());
	 * streamVideo4.addInputStream(inputStreamVideo4);
	 * 
	 * streamVideo4 = bitmovin.encoding.stream.addStream(encoding, streamVideo4);
	 * 
	 * Stream streamVideo5 = new Stream();
	 * 
	 * InputStream inputStreamVideo5 = new InputStream();
	 * inputStreamVideo5.setInputId(input.getId());
	 * inputStreamVideo5.setInputPath(inputPath);
	 * inputStreamVideo5.setSelectionMode(StreamSelectionMode.AUTO);
	 * 
	 * streamVideo5.setCodecConfigId(videoCodecConfig5.getId());
	 * streamVideo5.addInputStream(inputStreamVideo5);
	 * 
	 * streamVideo5 = bitmovin.encoding.stream.addStream(encoding, streamVideo5);
	 * 
	 * Stream streamVideo6 = new Stream();
	 * 
	 * InputStream inputStreamVideo6 = new InputStream();
	 * inputStreamVideo6.setInputId(input.getId());
	 * inputStreamVideo6.setInputPath(inputPath);
	 * inputStreamVideo6.setSelectionMode(StreamSelectionMode.AUTO);
	 * 
	 * streamVideo6.setCodecConfigId(videoCodecConfig6.getId());
	 * streamVideo6.addInputStream(inputStreamVideo6);
	 * 
	 * streamVideo6 = bitmovin.encoding.stream.addStream(encoding, streamVideo6);
	 * 
	 * Stream inputStreamAudio = new Stream();
	 * 
	 * InputStream inputStream = new InputStream();
	 * inputStream.setInputId(input.getId()); inputStream.setInputPath(inputPath);
	 * inputStream.setSelectionMode(StreamSelectionMode.AUTO);
	 * 
	 * inputStreamAudio.setCodecConfigId(audioCodecConfig.getId());
	 * inputStreamAudio.addInputStream(inputStream);
	 * 
	 * inputStreamAudio = bitmovin.encoding.stream.addStream(encoding,
	 * inputStreamAudio);
	 * 
	 * AclEntry aclEntry = new AclEntry();
	 * aclEntry.setPermission(AclPermission.PUBLIC_READ); List<AclEntry> aclEntries
	 * = new ArrayList<AclEntry>(); aclEntries.add(aclEntry);
	 * 
	 * double segmentLength = 4D; String nomeConcatenado = nome.trim() + "_" +
	 * System.currentTimeMillis(); String outputPath = "/output/carlosdv93/" +
	 * nomeConcatenado; String segmentNaming = "seg_%number%.m4s"; String
	 * initSegmentName = "init.mp4";
	 * 
	 * FMP4Muxing videoMuxing1 = new FMP4Muxing();
	 * 
	 * MuxingStream muxingStream1 = new MuxingStream();
	 * muxingStream1.setStreamId(streamVideo1.getId());
	 * 
	 * EncodingOutput videoMuxingOutput1 = new EncodingOutput();
	 * videoMuxingOutput1.setOutputId(outputId);
	 * videoMuxingOutput1.setOutputPath(String.format("%s%s", outputPath,
	 * "/video/384_240000/fmp4/")); videoMuxingOutput1.setAcl(aclEntries);
	 * 
	 * videoMuxing1.setSegmentLength(segmentLength);
	 * videoMuxing1.setSegmentNaming(segmentNaming);
	 * videoMuxing1.setInitSegmentName(initSegmentName);
	 * videoMuxing1.addStream(muxingStream1);
	 * videoMuxing1.addOutput(videoMuxingOutput1);
	 * 
	 * videoMuxing1 = bitmovin.encoding.muxing.addFmp4MuxingToEncoding(encoding,
	 * videoMuxing1);
	 * 
	 * FMP4Muxing videoMuxing2 = new FMP4Muxing();
	 * 
	 * MuxingStream muxingStream2 = new MuxingStream();
	 * muxingStream2.setStreamId(streamVideo2.getId());
	 * 
	 * EncodingOutput videoMuxingOutput2 = new EncodingOutput();
	 * videoMuxingOutput2.setOutputId(outputId);
	 * videoMuxingOutput2.setOutputPath(String.format("%s%s", outputPath,
	 * "/video/384_375000/fmp4/")); videoMuxingOutput2.setAcl(aclEntries);
	 * 
	 * videoMuxing2.setSegmentLength(segmentLength);
	 * videoMuxing2.setSegmentNaming(segmentNaming);
	 * videoMuxing2.setInitSegmentName(initSegmentName);
	 * videoMuxing2.addStream(muxingStream2);
	 * videoMuxing2.addOutput(videoMuxingOutput2);
	 * 
	 * videoMuxing2 = bitmovin.encoding.muxing.addFmp4MuxingToEncoding(encoding,
	 * videoMuxing2);
	 * 
	 * FMP4Muxing videoMuxing3 = new FMP4Muxing();
	 * 
	 * MuxingStream muxingStream3 = new MuxingStream();
	 * muxingStream3.setStreamId(streamVideo3.getId());
	 * 
	 * EncodingOutput videoMuxingOutput3 = new EncodingOutput();
	 * videoMuxingOutput3.setOutputId(outputId);
	 * videoMuxingOutput3.setOutputPath(String.format("%s%s", outputPath,
	 * "/video/512_550000/fmp4/")); videoMuxingOutput3.setAcl(aclEntries);
	 * 
	 * videoMuxing3.setSegmentLength(segmentLength);
	 * videoMuxing3.setSegmentNaming(segmentNaming);
	 * videoMuxing3.setInitSegmentName(initSegmentName);
	 * videoMuxing3.addStream(muxingStream3);
	 * videoMuxing3.addOutput(videoMuxingOutput3);
	 * 
	 * videoMuxing3 = bitmovin.encoding.muxing.addFmp4MuxingToEncoding(encoding,
	 * videoMuxing3);
	 * 
	 * FMP4Muxing videoMuxing4 = new FMP4Muxing();
	 * 
	 * MuxingStream muxingStream4 = new MuxingStream();
	 * muxingStream4.setStreamId(streamVideo4.getId());
	 * 
	 * EncodingOutput videoMuxingOutput4 = new EncodingOutput();
	 * videoMuxingOutput4.setOutputId(outputId);
	 * videoMuxingOutput4.setOutputPath(String.format("%s%s", outputPath,
	 * "/video/640_750000/fmp4/")); videoMuxingOutput4.setAcl(aclEntries);
	 * 
	 * videoMuxing4.setSegmentLength(segmentLength);
	 * videoMuxing4.setSegmentNaming(segmentNaming);
	 * videoMuxing4.setInitSegmentName(initSegmentName);
	 * videoMuxing4.addStream(muxingStream4);
	 * videoMuxing4.addOutput(videoMuxingOutput4);
	 * 
	 * videoMuxing4 = bitmovin.encoding.muxing.addFmp4MuxingToEncoding(encoding,
	 * videoMuxing4);
	 * 
	 * FMP4Muxing videoMuxing5 = new FMP4Muxing();
	 * 
	 * MuxingStream muxingStream5 = new MuxingStream();
	 * muxingStream5.setStreamId(streamVideo5.getId());
	 * 
	 * EncodingOutput videoMuxingOutput5 = new EncodingOutput();
	 * videoMuxingOutput5.setOutputId(outputId);
	 * videoMuxingOutput5.setOutputPath(String.format("%s%s", outputPath,
	 * "/video/768_1000000/fmp4/")); videoMuxingOutput5.setAcl(aclEntries);
	 * 
	 * videoMuxing5.setSegmentLength(segmentLength);
	 * videoMuxing5.setSegmentNaming(segmentNaming);
	 * videoMuxing5.setInitSegmentName(initSegmentName);
	 * videoMuxing5.addStream(muxingStream5);
	 * videoMuxing5.addOutput(videoMuxingOutput5);
	 * 
	 * videoMuxing5 = bitmovin.encoding.muxing.addFmp4MuxingToEncoding(encoding,
	 * videoMuxing5);
	 * 
	 * FMP4Muxing videoMuxing6 = new FMP4Muxing();
	 * 
	 * MuxingStream muxingStream6 = new MuxingStream();
	 * muxingStream6.setStreamId(streamVideo6.getId());
	 * 
	 * EncodingOutput videoMuxingOutput6 = new EncodingOutput();
	 * videoMuxingOutput6.setOutputId(outputId);
	 * videoMuxingOutput6.setOutputPath(String.format("%s%s", outputPath,
	 * "/video/1024_1500000/fmp4/")); videoMuxingOutput6.setAcl(aclEntries);
	 * 
	 * videoMuxing6.setSegmentLength(segmentLength);
	 * videoMuxing6.setSegmentNaming(segmentNaming);
	 * videoMuxing6.setInitSegmentName(initSegmentName);
	 * videoMuxing6.addStream(muxingStream6);
	 * videoMuxing6.addOutput(videoMuxingOutput6);
	 * 
	 * videoMuxing6 = bitmovin.encoding.muxing.addFmp4MuxingToEncoding(encoding,
	 * videoMuxing6);
	 * 
	 * // add the audio muxing to the encoding FMP4Muxing fmpAudio4Muxing = new
	 * FMP4Muxing();
	 * 
	 * MuxingStream muxingAudioStream = new MuxingStream();
	 * muxingAudioStream.setStreamId(inputStreamAudio.getId());
	 * 
	 * EncodingOutput encodingOutputFmp4Audio = new EncodingOutput();
	 * encodingOutputFmp4Audio.setOutputId(outputId);
	 * encodingOutputFmp4Audio.setOutputPath(String.format("%s%s", outputPath,
	 * "/audio/128000/fmp4/")); encodingOutputFmp4Audio.setAcl(aclEntries);
	 * 
	 * fmpAudio4Muxing.setSegmentLength(segmentLength);
	 * fmpAudio4Muxing.setSegmentNaming(segmentNaming);
	 * fmpAudio4Muxing.setInitSegmentName(initSegmentName);
	 * fmpAudio4Muxing.addStream(muxingAudioStream);
	 * fmpAudio4Muxing.addOutput(encodingOutputFmp4Audio);
	 * 
	 * fmpAudio4Muxing = bitmovin.encoding.muxing.addFmp4MuxingToEncoding(encoding,
	 * fmpAudio4Muxing);
	 * 
	 * // create the manifest DashManifest manifest = new DashManifest(); Period
	 * period = new Period();
	 * 
	 * EncodingOutput encodingOutput = new EncodingOutput();
	 * encodingOutput.setOutputId(outputId);
	 * encodingOutput.setOutputPath(outputPath); encodingOutput.setAcl(aclEntries);
	 * 
	 * manifest.setName(nome.trim() + "_manifest.mpd");
	 * manifest.addOutput(encodingOutput);
	 * 
	 * manifest = bitmovin.manifest.dash.create(manifest); period =
	 * bitmovin.manifest.dash.createPeriod(manifest, period);
	 * 
	 * VideoAdaptationSet videoAdaptationSet = new VideoAdaptationSet();
	 * 
	 * AudioAdaptationSet audioAdaptationSet = new AudioAdaptationSet();
	 * audioAdaptationSet.setLang("en");
	 * 
	 * videoAdaptationSet =
	 * bitmovin.manifest.dash.addVideoAdaptationSetToPeriod(manifest, period,
	 * videoAdaptationSet);
	 * 
	 * audioAdaptationSet =
	 * bitmovin.manifest.dash.addAudioAdaptationSetToPeriod(manifest, period,
	 * audioAdaptationSet);
	 * 
	 * DashFmp4Representation audioRepresentation = new DashFmp4Representation();
	 * audioRepresentation.setType(DashMuxingType.TEMPLATE);
	 * audioRepresentation.setEncodingId(encoding.getId());
	 * audioRepresentation.setMuxingId(fmpAudio4Muxing.getId());
	 * audioRepresentation.setSegmentPath("audio/128000/fmp4");
	 * 
	 * bitmovin.manifest.dash.addRepresentationToAdaptationSet(manifest, period,
	 * audioAdaptationSet, audioRepresentation);
	 * 
	 * DashFmp4Representation videoRepresentation1 = new DashFmp4Representation();
	 * videoRepresentation1.setType(DashMuxingType.TEMPLATE);
	 * videoRepresentation1.setEncodingId(encoding.getId());
	 * videoRepresentation1.setMuxingId(videoMuxing1.getId());
	 * videoRepresentation1.setSegmentPath("video/384_240000/fmp4");
	 * 
	 * bitmovin.manifest.dash.addRepresentationToAdaptationSet(manifest, period,
	 * videoAdaptationSet, videoRepresentation1);
	 * 
	 * DashFmp4Representation videoRepresentation2 = new DashFmp4Representation();
	 * videoRepresentation2.setType(DashMuxingType.TEMPLATE);
	 * videoRepresentation2.setEncodingId(encoding.getId());
	 * videoRepresentation2.setMuxingId(videoMuxing2.getId());
	 * videoRepresentation2.setSegmentPath("video/384_375000/fmp4");
	 * 
	 * bitmovin.manifest.dash.addRepresentationToAdaptationSet(manifest, period,
	 * videoAdaptationSet, videoRepresentation2);
	 * 
	 * DashFmp4Representation videoRepresentation3 = new DashFmp4Representation();
	 * videoRepresentation3.setType(DashMuxingType.TEMPLATE);
	 * videoRepresentation3.setEncodingId(encoding.getId());
	 * videoRepresentation3.setMuxingId(videoMuxing3.getId());
	 * videoRepresentation3.setSegmentPath("video/512_550000/fmp4");
	 * 
	 * bitmovin.manifest.dash.addRepresentationToAdaptationSet(manifest, period,
	 * videoAdaptationSet, videoRepresentation3);
	 * 
	 * DashFmp4Representation videoRepresentation4 = new DashFmp4Representation();
	 * videoRepresentation4.setType(DashMuxingType.TEMPLATE);
	 * videoRepresentation4.setEncodingId(encoding.getId());
	 * videoRepresentation4.setMuxingId(videoMuxing4.getId());
	 * videoRepresentation4.setSegmentPath("video/640_750000/fmp4");
	 * 
	 * bitmovin.manifest.dash.addRepresentationToAdaptationSet(manifest, period,
	 * videoAdaptationSet, videoRepresentation4);
	 * 
	 * DashFmp4Representation videoRepresentation5 = new DashFmp4Representation();
	 * videoRepresentation5.setType(DashMuxingType.TEMPLATE);
	 * videoRepresentation5.setEncodingId(encoding.getId());
	 * videoRepresentation5.setMuxingId(videoMuxing5.getId());
	 * videoRepresentation5.setSegmentPath("video/768_1000000/fmp4");
	 * 
	 * bitmovin.manifest.dash.addRepresentationToAdaptationSet(manifest, period,
	 * videoAdaptationSet, videoRepresentation5);
	 * 
	 * DashFmp4Representation videoRepresentation6 = new DashFmp4Representation();
	 * videoRepresentation6.setType(DashMuxingType.TEMPLATE);
	 * videoRepresentation6.setEncodingId(encoding.getId());
	 * videoRepresentation6.setMuxingId(videoMuxing6.getId());
	 * videoRepresentation6.setSegmentPath("video/1024_1500000/fmp4");
	 * 
	 * bitmovin.manifest.dash.addRepresentationToAdaptationSet(manifest, period,
	 * videoAdaptationSet, videoRepresentation6);
	 * 
	 * // start the encoding bitmovin.encoding.start(encoding);
	 * 
	 * System.out.println("Encoding started, check your encoding progress here:");
	 * System.out.println(
	 * "https://bitmovin.com/dashboard/getting-started/encoding/ui/5/" +
	 * encoding.getId());
	 * 
	 * Task encodingStatus = bitmovin.encoding.getStatus(encoding);
	 * 
	 * // wait for the encoding to be finished while (encodingStatus.getStatus() !=
	 * Status.FINISHED && encodingStatus.getStatus() != Status.ERROR) {
	 * encodingStatus = bitmovin.encoding.getStatus(encoding);
	 * System.out.println(String.format("Encoding progress: %s",
	 * encodingStatus.getProgress())); Thread.sleep(2500); }
	 * 
	 * // start and wait for the manifest to be finished
	 * bitmovin.manifest.dash.startGeneration(manifest);
	 * 
	 * Status manifestStatus = bitmovin.manifest.dash.getGenerationStatus(manifest);
	 * 
	 * System.out.println("Generating DASH manifest..."); while (manifestStatus !=
	 * Status.FINISHED && manifestStatus != Status.ERROR) { manifestStatus =
	 * bitmovin.manifest.dash.getGenerationStatus(manifest);
	 * System.out.println(String.format("Manifest generation status: %s",
	 * manifestStatus.toString())); Thread.sleep(2500); }
	 * 
	 * System.out.println("Everything finished, check your encoding here:");
	 * System.out.println(
	 * "https://bitmovin.com/dashboard/getting-started/encoding/ui/5/" +
	 * encoding.getId()); System.out.println(manifest.getName());
	 * System.out.println(manifest.getOutputs().get(0).getOutputPath());
	 * System.out.println(manifest.getOrgId());
	 * System.out.println(manifest.getId()); System.out.println(outputPath); return
	 * manifest; }
	 */

}
