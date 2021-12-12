package com.ertugrul.springboot.controller;

import com.ertugrul.springboot.converter.UserConverter;
import com.ertugrul.springboot.dto.UserDto;
import com.ertugrul.springboot.entity.User;
import com.ertugrul.springboot.exception.UserNotFoundException;
import com.ertugrul.springboot.service.UserService;
import com.ertugrul.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @GetMapping(value = {"", "/"})
    public List<UserDto> findAll() {

        List<User> userList = userService.findAll();

        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUserListToUserDtoList(userList);

        return userDtoList;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        User user = userService.findById(id);

        if (user == null) {
            throw new UserNotFoundException("User not found. id: " + id);
        }

        return user;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody UserDto userDto) {

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        user = userService.save(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public UserDto update(@RequestBody UserDto userDto, @PathVariable Long id) {
        User userFromIdParam = userService.findById(id);
        if (userFromIdParam == null) {
            throw new UserNotFoundException("User not found. id: " + id);
        }
        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);

        user.setId(userFromIdParam.getId());

        user = userService.save(user);

        UserDto userDtoResult = UserConverter.INSTANCE.convertUserToUserDto(user);

        return userDtoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }


    /*Example Req: GET http://localhost:8080/api/users?username=ertugrulg */
    @GetMapping(
            value = "",
            params = "username"
    )
    public User findByUserName(@RequestParam(value = "username") String userName) {

        User user = userService.findByUserName(userName);

        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }

        return user;
    }

    /*Example Req: GET http://localhost:8080/api/users?phone=5370540004 */
    @GetMapping(
            value = "",
            params = "phone"
    )
    public User findByPhone(@RequestParam(value = "phone") String phone) {

        User user = userService.findByPhone(phone);

        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }

        return user;
    }


    /*Example Req:  DELETE http://localhost:8080/api/users?username=mehmet12431&phone=5370001003*/
    @DeleteMapping(
            value = "",
            params = {"phone", "username"}
    )
    public void deleteByPhoneAndUserName(@RequestParam(value = "phone") String phone,
                                         @RequestParam(value = "username") String username) {
        User user = userService.findByPhoneAndUserName(phone, username);
        if (user == null) {
            throw new UserNotFoundException("Invalid username or phone number");
        } else {
            userService.deleteById(user.getId());
        }
    }
}
