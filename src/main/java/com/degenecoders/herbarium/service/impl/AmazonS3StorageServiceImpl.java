package com.degenecoders.herbarium.service.impl;


import com.degenecoders.herbarium.service.StorageService;
import org.apache.commons.codec.binary.Base64;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
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
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(fileName)
                .build();
        PutObjectResponse putResponse = s3.putObject(putObjectRequest,RequestBody.fromBytes(bytes));
    }

    @Override
    public String retrieve(String fileName) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(fileName)
                .build();
        ResponseBytes<GetObjectResponse> objectBytes = s3.getObjectAsBytes(getObjectRequest);
        return encodeToBase64(objectBytes);
    }

    /**
     * Encodes image into Base64
     *
     * @param objectBytes image in bytes
     * @return {@link String}
     */
    private String encodeToBase64(ResponseBytes<GetObjectResponse> objectBytes){
        byte[] bytes = objectBytes.asByteArray();
        String base64String = Base64.encodeBase64String(bytes);

        return base64String;
    }
}
