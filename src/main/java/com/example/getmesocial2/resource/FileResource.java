package com.example.getmesocial2.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocial2.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.getmesocial2.service.FirebaseService;

import com.example.getmesocial2.model.FirebaseUser;

import com.google.firebase.auth.FirebaseAuthException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.example.getmesocial2.exception.InvalidIdToken;



@RestController
@RequestMapping("api/files")
public class FileResource {

   @Autowired
   private FileService fileService;


    @Autowired
    private FirebaseService firebaseService;
    @PostMapping
    public boolean upload(@RequestParam(name="file")MultipartFile file,

                          @RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException ,InvalidIdToken{

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null) {
            return fileService.upload(file);

        }
        else {
            throw new InvalidIdToken();
        }

    }

    @GetMapping("/view")
    public void view(@RequestParam(name="key") String key, HttpServletResponse response) throws IOException {

       S3Object object = fileService.getFile(key);
       response.setContentType(object.getObjectMetadata().getContentType());
       response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }


    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam(name = "key") String key) throws IOException {

        S3Object object = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));



    }

    @DeleteMapping
    public void delete(@RequestParam(name = "key") String key,
                       @RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException,InvalidIdToken {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            fileService.deleteFile(key);

        }
        else
            throw new InvalidIdToken();

    }




}
