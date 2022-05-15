package com.degenecoders.herbarium.service.impl;


import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AmazonS3StorageServiceImpl implements StorageService {

    private static final String BUCKET_NAME = "herabarium-bucket";

    @Inject
    S3Client s3;

    @Override
    public void store(String fileName, byte[] bytes) {
        s3.listBuckets();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(fileName)
                .build();
        PutObjectResponse putResponse = s3.putObject(putObjectRequest,RequestBody.fromBytes(bytes));
    }
}
