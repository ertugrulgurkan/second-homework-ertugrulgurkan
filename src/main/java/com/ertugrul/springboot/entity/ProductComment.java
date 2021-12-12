package com.ertugrul.springboot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_COMMENT")
public class ProductComment {

    @SequenceGenerator(name = "generator", sequenceName = "PRODUCT_COMMENT_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(length = 500, name = "COMMENT")
    private String comment;

    @Column(name = "COMMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",
            foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_USER_ID")
    )
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID",
            foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_PRODUCT_ID")
    )
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}