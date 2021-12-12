package com.ertugrul.springboot.converter;

import com.ertugrul.springboot.dto.ProductCommentDto;
import com.ertugrul.springboot.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentConverter {

    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    @Mapping(source = "productName", target = "product.name")
    @Mapping(source = "price", target = "product.price")
    @Mapping(source = "userUsername", target = "user.username")
    @Mapping(source = "userSurname", target = "user.surname")
    @Mapping(source = "userEmail", target = "user.email")
    @Mapping(source = "userPhone", target = "user.phone")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "commentId", target = "id")
    ProductComment convertProductCommentDtoToProductComment(ProductCommentDto productCommentDto);


    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "userUsername", source = "user.username")
    @Mapping(target = "userSurname", source = "user.surname")
    @Mapping(target = "userEmail", source = "user.email")
    @Mapping(target = "userPhone", source = "user.phone")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "commentId", source = "id")
    ProductCommentDto convertProductCommentToProductCommentDto(ProductComment productComment);


    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "userUsername", source = "user.username")
    @Mapping(target = "userSurname", source = "user.surname")
    @Mapping(target = "userEmail", source = "user.email")
    @Mapping(target = "userPhone", source = "user.phone")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "commentId", source = "id")
    List<ProductCommentDto> convertAllProductCommentListToProductCommentDtoList(List<ProductComment> productCommentList);


}
