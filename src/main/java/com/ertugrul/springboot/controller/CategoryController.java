package com.ertugrul.springboot.controller;

import com.ertugrul.springboot.converter.CategoryConverter;
import com.ertugrul.springboot.converter.ProductConverter;
import com.ertugrul.springboot.dto.CategoryDto;
import com.ertugrul.springboot.dto.ProductDetailDto;
import com.ertugrul.springboot.entity.Category;
import com.ertugrul.springboot.entity.Product;
import com.ertugrul.springboot.exception.CategoryNotFoundException;
import com.ertugrul.springboot.service.CategoryService;
import com.ertugrul.springboot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Api üzerinden kategorilere erişmek için yazılmış controller sınıfı
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }


    @GetMapping(value = {"", "/"})
    public List<CategoryDto> findAll() {

        List<Category> categoryList = categoryService.findAll();

        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {

        Category category = categoryService.findById(id);

        if (category == null) {
            throw new CategoryNotFoundException("Category not found. id: " + id);
        }

        CategoryDto categoryDto = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);

        return categoryDto;
    }


    @PostMapping(value = {"", "/"})
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto) {

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        category = categoryService.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = {"", "/"})
    public CategoryDto update(@RequestBody CategoryDto categoryDto) {

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        category = categoryService.save(category);

        CategoryDto categoryDtoResult = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);

        return categoryDtoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    // localhost:8080/api/category/{id}/products
    @GetMapping("/{id}/products")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long id) {
        List<Product> productList = productService.findAllByCategoryOrderByIdDesc(id);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }
}
