package com.ertugrul.springboot.converter;

import com.ertugrul.springboot.dto.ProductDto;
import com.ertugrul.springboot.dto.UserDto;
import com.ertugrul.springboot.entity.Product;
import com.ertugrul.springboot.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto convertUserToUserDto(User user);

    List<UserDto> convertAllUserListToUserDtoList(List<User> userList);

    User convertUserDtoToUser(UserDto userDto);

    @AfterMapping
    default void setNulls(@MappingTarget final Product product, ProductDto productDto) {
        if (productDto.getCategoryId() == null) {
            product.setCategory(null);
        }
    }

}
