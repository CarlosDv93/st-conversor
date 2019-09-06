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
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.carlosdv93.config.BitmovinConfig;
import com.carlosdv93.config.S3Credential;
import com.carlosdv93.models.responses.EncodingResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
@PropertySource("aws.config.properties")
public class S3Service {

	private Logger log = org.slf4j.LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${aws.config.s3.bucket}")
	private String bucketName;
	
	@Value("${aws.config.access_key_id}")
	private String awsId;

	@Value("${aws.config.secret_access_key}")
	private String awsKey;

	@Value("${aws.config.s3.region}")
	private String region;
	
	

	public ResponseEntity<String> uploadFile(MultipartFile multipartFile) throws Exception {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is;
			is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();

			return uploadFile(is, fileName, contentType);
		} catch (Exception e) {
			throw new IOException("Erro de IO: " + e.getMessage());
		}

	}

	public ResponseEntity<String> uploadFile(InputStream is, String fileName, String contentType) throws Exception {
			BitmovinConfig bitmovinConfig = new BitmovinConfig();
			S3Credential s3Creds = s3Credential();
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
			log.info(s3client.getUrl(bucketName+"/input", fileName).toURI().toString());
			
			return bitmovinConfig.converter(s3client.getUrl(bucketName+"/input", fileName).toURI(), s3Creds);
			
		} catch (Exception e) {
			throw new Exception("Erro ao converter URL para URI " + e.getMessage());
		}

	}
	
	public S3Credential s3Credential() {
		S3Credential s3cred = new S3Credential();
		s3cred.setAccessKey(awsId);
		s3cred.setSecretKey(awsKey);
		s3cred.setBucketName(bucketName);
		
		return s3cred;
		
	}
}