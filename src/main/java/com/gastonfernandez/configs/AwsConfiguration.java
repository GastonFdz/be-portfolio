package com.gastonfernandez.configs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AwsConfiguration {
	public final String accessKey="AKIAV6JOWGI5JQLF6JGE";
	public final String secretKey="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";
	@Bean
	public AWSStaticCredentialsProvider credentialsProvider() {
		return new AWSStaticCredentialsProvider(
				new BasicAWSCredentials(accessKey,
						secretKey));
	}
	@Bean
	public AmazonSimpleEmailService simpleEmailService(AWSStaticCredentialsProvider credentials) {
		return AmazonSimpleEmailServiceClientBuilder
				.standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(credentials)
				.build();

	}
}
