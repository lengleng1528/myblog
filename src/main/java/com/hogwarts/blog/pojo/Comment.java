package com.hogwarts.blog.pojo;

import com.hogwarts.blog.vo.ParentComment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Comment {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private boolean adminComment;
    private String avatar;

    private Date createTime;


    private Blog blog;


    private List<Comment> replyComments = new ArrayList<>();


    private Long parentCommentId;

    private Comment parentComment;

    private ParentComment parentComment1 ;

    public Comment() {
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Blog getBlog() {

        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public ParentComment getParentComment1() {
        return parentComment1;
    }

    public void setParentComment1(ParentComment parentComment1) {
        this.parentComment1 = parentComment1;
    }

    public boolean isAdminComment() {
        return adminComment;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", adminComment=" + adminComment +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blog=" + blog +
                ", parentComment=" + parentComment +
                '}';
    }
}
