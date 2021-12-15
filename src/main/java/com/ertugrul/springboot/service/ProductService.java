package com.ertugrul.springboot.service;


import com.ertugrul.springboot.dao.ProductDao;
import com.ertugrul.springboot.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Ürünler ile ilgili dataya controllerdan erişebilmek için yazılmış Servis.
@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productDao.findById(id);

        Product product = null;
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
        }

        return product;
    }

    public Product save(Product product) {
        product = productDao.save(product);

        return product;
    }

    public void delete(Product product) {
        productDao.delete(product);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public long count() {
        return productDao.count();
    }

    public List<Product> findAllByCategoryOrderByIdDesc(Long categoryId) {
        return productDao.findAllByCategoryOrderByIdDesc(categoryId);
    }

}
