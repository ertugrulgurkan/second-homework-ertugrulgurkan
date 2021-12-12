package com.ertugrul.springboot.dto;

public class CategoryDto {

    private Long id;
    private String name;
    private Long depth;
    private Long topCategoryId;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String name, Long depth, Long topCategoryId) {
        this.id = id;
        this.name = name;
        this.depth = depth;
        this.topCategoryId = topCategoryId;
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

    public Long getDepth() {
        return depth;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public Long getTopCategoryId() {
        return topCategoryId;
    }

    public void setTopCategoryId(Long topCategoryId) {
        this.topCategoryId = topCategoryId;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depth=" + depth +
                ", topCategoryId=" + topCategoryId +
                '}';
    }
}
