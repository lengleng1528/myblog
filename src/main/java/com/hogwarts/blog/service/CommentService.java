package com.hogwarts.blog.service;

import com.hogwarts.blog.pojo.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

}
