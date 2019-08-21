package com.carlosdv93.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
@Component
//@ConfigurationProperties(prefix = "aws.config")
@PropertySource("aws.config.properties")
public class S3Config {

	@Value("${aws.config.access_key_id}")
	private String awsId;

	@Value("${aws.config.secret_access_key}")
	private String awsKey;

	@Value("${aws.config.s3.region}")
	private String region;
	
	private String access_key_id; 
	private String secret_access_key; 
	private String s3_region;

	@Bean
	public AmazonS3 s3client() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		return s3Client;
	}

	/*
	 * private String access_key_id; private String secret_access_key; private
	 * String s3_region;
	 * 
	 * @Bean public AmazonS3 s3client() { BasicAWSCredentials awsCreds = new
	 * BasicAWSCredentials(access_key_id, secret_access_key); AmazonS3 s3Client =
	 * AmazonS3ClientBuilder.standard() .withRegion(Regions.fromName(s3_region))
	 * .withCredentials(new AWSStaticCredentialsProvider(awsCreds)) .build();
	 * 
	 * return s3Client; }
	 */
}
