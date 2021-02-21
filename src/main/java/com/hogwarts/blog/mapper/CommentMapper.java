package com.hogwarts.blog.mapper;


import com.hogwarts.blog.pojo.Comment;

import java.util.List;

public interface CommentMapper {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId);

    List<Comment> findReplyCommentsByParentCommentId(Long parentCommentId);

    Comment findOne(Long parentCommentId);

    void save(Comment comment);



    Comment findById(Long id);

}
