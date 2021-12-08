package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.Comment;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.getmesocial2.service.FirebaseService;

import com.example.getmesocial2.model.FirebaseUser;

import com.google.firebase.auth.FirebaseAuthException;
import com.example.getmesocial2.exception.InvalidIdToken;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment,@RequestHeader(name="idToken") String idToken) throws IOException,InvalidIdToken
    ,FirebaseAuthException {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return commentService.saveComment(comment);
        }
        else
            throw new InvalidIdToken();
    }





    @GetMapping
    public List<Comment> getAllComment() {

        return commentService.getAllComment();
    }


    @PutMapping
    public Comment updateComment(@RequestBody Comment comment,@RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException ,InvalidIdToken{


        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return commentService.updateCommentById(comment);
        }
        else
            throw new InvalidIdToken();
    }




    @DeleteMapping
    public void deleteComment(@RequestParam(name = "commentId") String commentId,@RequestHeader(name="idToken") String idToken) throws  IOException, FirebaseAuthException,InvalidIdToken {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            commentService.deleteComment(commentId);

        }
        else
            throw new InvalidIdToken();



    }
    @GetMapping("/find")
    public List<Comment> getById(@RequestParam(name = "id") String id){

        return  commentService.getById(id);

    }




}
