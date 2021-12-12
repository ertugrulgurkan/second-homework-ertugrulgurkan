package com.ertugrul.springboot.dto;

import java.util.Date;

public class UserActionDto {
    private Long userId;
    private String userName;
    private String productName;
    private String comment;
    private Date commentDate;

    public UserActionDto(Long userId, String userName, String productName, String comment, Date commentDate) {
        this.userId = userId;
        this.userName = userName;
        this.productName = productName;
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public UserActionDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "UserActionDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}
