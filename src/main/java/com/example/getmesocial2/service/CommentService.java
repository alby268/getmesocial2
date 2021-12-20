package com.example.getmesocial2.service;

import com.example.getmesocial2.model.Comment;
import com.example.getmesocial2.model.User;
import com.example.getmesocial2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComment() {

        return commentRepository.findAll();
    }

    public Comment updateCommentById(Comment comment) {

        return commentRepository.save(comment);
    }

    public void deleteComment(String commentId) {

        commentRepository.deleteById(commentId);
    }

    public List<Comment> getById(String id) {

        return commentRepository.findAllById(id);
    }

    public List<Comment> getByPhotoId(String photoId) {

        return commentRepository.findByPhotoId(photoId);
    }


}
