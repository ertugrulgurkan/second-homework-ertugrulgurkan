package com.ertugrul.springboot.service;

import com.ertugrul.springboot.dao.CategoryDao;
import com.ertugrul.springboot.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    public List<Category> findAll() {
        return (List<Category>) categoryDao.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryDao.findById(id);

        Category category = null;
        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
        }

        return category;
    }

    public Category save(Category category) {
        return categoryDao.save(category);
    }

    public void delete(Category category) {
        categoryDao.delete(category);
    }

    public void deleteById(Long id) {
        categoryDao.deleteById(id);
    }

    public long count() {
        return categoryDao.count();
    }

    public List<Category> findAllByTopCategoryIsNullOrderByNameDesc() {
        return categoryDao.findAllByTopCategoryIsNullOrderByNameDesc();
    }

    public List<Category> findAllByAdiEndsWith(String name) {
        return categoryDao.findAllByNameEndsWith(name);
    }
}