package com.ertugrul.springboot.service;

import com.ertugrul.springboot.dao.ProductCommentDao;
import com.ertugrul.springboot.entity.ProductComment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCommentService {

    private final ProductCommentDao productCommentDao;

    public ProductCommentService(ProductCommentDao productCommentDao) {
        this.productCommentDao = productCommentDao;
    }

    public List<ProductComment> findAll() {
        return (List<ProductComment>) productCommentDao.findAll();
    }

    public ProductComment findById(Long id) {
        Optional<ProductComment> optionalProductComment = productCommentDao.findById(id);

        ProductComment productComment = null;
        if (optionalProductComment.isPresent()) {
            productComment = optionalProductComment.get();
        }

        return productComment;
    }

    public ProductComment save(ProductComment productComment) {
        productComment = productCommentDao.save(productComment);

        return productComment;
    }

    public void delete(ProductComment productComment) {
        productCommentDao.delete(productComment);
    }

    public void deleteById(Long id) {
        productCommentDao.deleteById(id);
    }

    public long count() {
        return productCommentDao.count();
    }

    public List<ProductComment> findCommentByUsername(String username) {
        List<ProductComment> productCommentList = productCommentDao.findByUser_Username(username);
        return productCommentList;
    }


    public List<ProductComment> findProductCommentByUserId(Long id) {
        List<ProductComment> productCommentList = productCommentDao.findByProduct_Id(id);
        return productCommentList;
    }


}
