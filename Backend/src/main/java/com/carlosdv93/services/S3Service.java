package com.carlosdv93.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.carlosdv93.config.BitmovinConfig;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
@PropertySource("aws.config.properties")
public class S3Service {

	private Logger log = org.slf4j.LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${aws.config.s3.bucket}")
	private String bucketName;

	public URI uploadFile(MultipartFile multipartFile) throws IOException, URISyntaxException, BitmovinApiException, UnirestException, RestException, InterruptedException {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is;
			is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();

			return uploadFile(is, fileName, contentType);
		} catch (IOException e) {
			throw new IOException("Erro de IO: " + e.getMessage());
		}

	}

	public URI uploadFile(InputStream is, String fileName, String contentType) throws URISyntaxException, IOException, BitmovinApiException, UnirestException, RestException, InterruptedException {
			BitmovinConfig bitmovinConfig = new BitmovinConfig();
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			log.info("Iniciando Upload........");
			s3client.putObject(bucketName+"/input", fileName, is, meta);
			log.info(fileName);
			log.info(contentType);
			log.info("Filename: " + FilenameUtils.getBaseName(fileName));
			log.info("Upload Finalizado!!!");
			log.info("Bucket: " + bucketName);
			log.info(s3client.getUrl(bucketName, fileName).toURI().toString());
			
			DashManifest manifest = bitmovinConfig.converter(fileName, s3client.getUrl(bucketName+"/input", fileName)); 
			
			log.info("manifest out: " + manifest.getOutputs().get(0).getOutputPath().toString().trim());
			log.info(fileName.trim());

			//return s3client.getUrl(bucketName, fileName).toURI();
			URI url = new URI("https://st-bucket-carlosdv93.s3-sa-east-1.amazonaws.com" + manifest.getOutputs().get(0).getOutputPath().toString().trim() + "/" 
								+ fileName.trim() + "_manifest.mpd");
			
			return url;
		} catch (URISyntaxException e) {
			throw new URISyntaxException("Erro ao converter URL para URI", e.getMessage());
		}

	}

}