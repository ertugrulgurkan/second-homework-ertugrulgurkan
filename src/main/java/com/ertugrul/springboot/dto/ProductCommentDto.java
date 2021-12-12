package com.ertugrul.springboot.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductCommentDto {

    private String productName;
    private String categoryName;
    private BigDecimal price;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userPhone;
    private String comment;
    private Date commentDate;

    public ProductCommentDto(String productName, String categoryName, BigDecimal price, String userName, String userSurname, String userEmail, String userPhone, String comment, Date commentDate) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
        this.userName = userName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "ProductCommentDto{" +
                "productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}