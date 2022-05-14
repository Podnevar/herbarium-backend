package com.degenecoders.herbarium.service.impl;


import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AmazonS3StorageServiceImpl implements StorageService {

    private static final String BUCKET_NAME = "herabarium-bucket";

    @Inject
    S3Client s3;

    @Override
    public void store(String fileName, byte[] bytes) {
//        if (formData.filename == null || formData.filename.isEmpty()) {
//            return Response.status(Status.BAD_REQUEST).build();
//        }
//
//        if (formData.mimetype == null || formData.mimetype.isEmpty()) {
//            return Response.status(Status.BAD_REQUEST).build();
//        }
        s3.listBuckets();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(fileName)
                .build();
        PutObjectResponse putResponse = s3.putObject(putObjectRequest,RequestBody.fromBytes(bytes));
//        if (putResponse != null) {
//            return Response.ok().status(Status.CREATED).build();
//        } else {
//            return Response.serverError().build();
//        }
    }

//    public Response downloadFile(String objectKey) {
//        S3Object s3object = s3.getObject(BUCKET_NAME, "picture/pic.png");
//        S3ObjectInputStream inputStream = s3object.get;
//        FileUtils.copyInputStreamToFile(inputStream, new File("/Users/user/Desktop/hello.txt"));
//    }
}
