package com.ertugrul.springboot.converter;

import com.ertugrul.springboot.dto.UserDto;
import com.ertugrul.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto convertUserToUserDto(User user);

    List<UserDto> convertAllUserListToUserDtoList(List<User> userList);

    User convertUserDtoToUser(UserDto userDto);

}
