package com.example.getmesocial2.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    public boolean upload(MultipartFile file) {

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAXVZDHZYRFLLS3KK3","ngtCljvN8VVuki9QhBmrJdPGP1pRiZAJICaBUp4B");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            s3.putObject("backendphotoalbum", file.getOriginalFilename(),file.getInputStream(),metadata);
            return true;
        } catch (AmazonServiceException | IOException e) {
            return false;

        }

    }


    public S3Object getFile(String key) {


        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAXVZDHZYRFLLS3KK3","ngtCljvN8VVuki9QhBmrJdPGP1pRiZAJICaBUp4B");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();
        return s3.getObject("backendphotoalbum", key);


    }


    public void deleteFile(String key) {


        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAXVZDHZYRFLLS3KK3","ngtCljvN8VVuki9QhBmrJdPGP1pRiZAJICaBUp4B");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();
         s3.deleteObject("backendphotoalbum", key);


    }
}
