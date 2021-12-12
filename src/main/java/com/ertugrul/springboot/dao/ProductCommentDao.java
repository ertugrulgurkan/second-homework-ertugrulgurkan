package com.ertugrul.springboot.dao;

import com.ertugrul.springboot.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCommentDao extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findByUser_Username(String username);

    List<ProductComment> findByProduct_Id(Long id);
}
