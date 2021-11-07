package com.example.getmesocial2.resource;

import com.example.getmesocial2.model.Comment;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }


    @GetMapping
    public List<Comment> getAllComment() {

        return commentService.getAllComment();
    }


    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){

        return commentService.updateCommentById(comment);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam(name = "commentId") String commentId){

        commentService.deleteComment(commentId);
    }
    @GetMapping("/find")
    public List<Comment> getById(@RequestParam(name = "id") String id){

        return  commentService.getById(id);

    }




}
