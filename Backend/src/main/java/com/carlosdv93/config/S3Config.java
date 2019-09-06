package com.carlosdv93.config;

import org.springframework.beans.factory.annotation.Value;
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
@PropertySource("aws.config.properties")
public class S3Config {

	@Value("${aws.config.access_key_id}")
	private String awsId;

	@Value("${aws.config.secret_access_key}")
	private String awsKey;

	@Value("${aws.config.s3.region}")
	private String region;
	
	@Value("${aws.config.s3.bucket}")
	private String bucketName;
	
	@Bean
	public AmazonS3 s3client() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		return s3Client;
	}
	
	@Bean
	public S3Credential s3Credential() {
		S3Credential s3cred = new S3Credential();
		s3cred.setAccessKey(awsId);
		s3cred.setSecretKey(awsKey);
		s3cred.setBucketName(bucketName);
		
		return s3cred;
		
	}
}
