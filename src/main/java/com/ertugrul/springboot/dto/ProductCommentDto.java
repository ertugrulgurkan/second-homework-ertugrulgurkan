package com.ertugrul.springboot.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductCommentDto {

    private Long commentId;
    private Long productId;
    private Long userId;
    private String productName;
    private BigDecimal price;
    private String userUsername;
    private String userSurname;
    private String userEmail;
    private String userPhone;
    private String comment;
    private Date commentDate;

    public ProductCommentDto(Long commentId, Long productId, Long userId, String productName, BigDecimal price, String userUsername, String userSurname, String userEmail, String userPhone, String comment, Date commentDate) {
        this.commentId = commentId;
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.userUsername = userUsername;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public ProductCommentDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}