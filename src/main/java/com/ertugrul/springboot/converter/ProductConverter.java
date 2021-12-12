package com.ertugrul.springboot.converter;

import com.ertugrul.springboot.dto.ProductDetailDto;
import com.ertugrul.springboot.dto.ProductDto;
import com.ertugrul.springboot.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    ProductDetailDto convertProductToProductDetailDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "adi", target = "productAdi")
    @Mapping(source = "category.name", target = "categoryName")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> productList);
}
