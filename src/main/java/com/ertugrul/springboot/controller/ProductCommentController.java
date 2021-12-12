package com.ertugrul.springboot.controller;


import com.ertugrul.springboot.converter.ProductCommentConverter;
import com.ertugrul.springboot.dto.ProductCommentDto;
import com.ertugrul.springboot.entity.ProductComment;
import com.ertugrul.springboot.entity.User;
import com.ertugrul.springboot.exception.CommentNotFoundException;
import com.ertugrul.springboot.exception.ProductNotFoundException;
import com.ertugrul.springboot.exception.UserNotFoundException;
import com.ertugrul.springboot.service.ProductCommentService;
import com.ertugrul.springboot.service.ProductService;
import com.ertugrul.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ProductComment productCommentById = productCommentService.findById(id);
        if (productCommentById == null)
            throw new CommentNotFoundException("Comment not found. id: " + id);
        else
            productCommentService.deleteById(id);
    }

    // GET http://localhost:8080/api/comments
    @GetMapping(value = {"", "/"})
    public List<ProductCommentDto> findAll() {

        List<ProductComment> productCommentList = productCommentService.findAll();

        List<ProductCommentDto> productCommentDtoList = ProductCommentConverter.INSTANCE.convertAllProductCommentListToProductCommentDtoList(productCommentList);

        return productCommentDtoList;
    }

    /*
    POST http://localhost:8080/api/comments
      {
        "productId": 2,
        "userId": 1,
        "comment": "Çok güzel bir ürün"
      }
    */
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Object> save(@RequestBody ProductCommentDto productCommentDto) {
        ProductComment productComment = ProductCommentConverter.INSTANCE.convertProductCommentDtoToProductComment(productCommentDto);
        if (userService.findById(productCommentDto.getUserId()) == null)
            throw new UserNotFoundException("User not found.");

        if (productService.findById(productCommentDto.getProductId()) == null)
            throw new ProductNotFoundException("Product not found.");

        productComment = productCommentService.save(productComment);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productComment.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }


    // Example Req:  http://localhost:8080/api/comments?username=ertugrulg
    @GetMapping(
            value = {"", "/"},
            params = "username"
    )
    public List<ProductCommentDto> findCommentByUsername(@RequestParam(value = "username") String username) {

        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        List<ProductComment> productCommentList = productCommentService.findCommentByUsername(username);

        if (productCommentList == null || productCommentList.size() == 0) {
            throw new CommentNotFoundException("The user has not written any comments yet.");
        }
        List<ProductCommentDto> productCommentDtoList = ProductCommentConverter.INSTANCE.convertAllProductCommentListToProductCommentDtoList(productCommentList);
        return productCommentDtoList;
    }

}
