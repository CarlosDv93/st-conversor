package com.carlosdv93.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
@PropertySource("aws.config.properties")
public class S3Service {

	private Logger log = org.slf4j.LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${aws.config.s3.bucket}")
	private String bucketName;

	public URI uploadFile(MultipartFile multipartFile) throws IOException, URISyntaxException {
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

	public URI uploadFile(InputStream is, String fileName, String contentType) throws URISyntaxException {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			log.info("Iniciando Upload........");
			s3client.putObject(bucketName, fileName, is, meta);
			log.info(fileName);
			log.info(contentType);
			log.info("Upload Finalizado!!!");
			log.info(s3client.getUrl(bucketName, fileName).toURI().toString());

			return s3client.getUrl(bucketName, fileName).toURI();
		} catch (URISyntaxException e) {
			throw new URISyntaxException("Erro ao converter URL para URI", contentType);
		}

	}

}