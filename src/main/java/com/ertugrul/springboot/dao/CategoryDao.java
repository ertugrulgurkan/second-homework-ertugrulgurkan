package com.ertugrul.springboot.dao;

import com.ertugrul.springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Long> {

    List<Category> findAllByTopCategoryIsNullOrderByNameDesc();

    List<Category> findAllByNameEndsWith(String name);

}
