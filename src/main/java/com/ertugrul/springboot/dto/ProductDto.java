package com.ertugrul.springboot.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private Date recordDate;
    private Long categoryId;

    public ProductDto(Long id, String name, BigDecimal price, Date recordDate, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.recordDate = recordDate;
        this.categoryId = categoryId;
    }

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", recordDate=" + recordDate +
                ", categoryId=" + categoryId +
                '}';
    }
}
