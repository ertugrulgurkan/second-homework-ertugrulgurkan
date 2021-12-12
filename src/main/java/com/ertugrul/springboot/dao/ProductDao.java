package com.ertugrul.springboot.dao;

import com.ertugrul.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {
}
