package com.ertugrul.springboot.dto;

import java.math.BigDecimal;

public class ProductSummaryDto {
    private Long productId;
    private String productName;
    private BigDecimal price;
    private Long commentCount;

    public ProductSummaryDto() {
    }

    public ProductSummaryDto(Long productId, String productName, BigDecimal price, Long commnetCount) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.commentCount = commnetCount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "ProductSummaryDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", commentCount=" + commentCount +
                '}';
    }
}
