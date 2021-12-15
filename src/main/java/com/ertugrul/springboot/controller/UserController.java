package com.ertugrul.springboot.controller;

import com.ertugrul.springboot.converter.UserConverter;
import com.ertugrul.springboot.dto.UserDto;
import com.ertugrul.springboot.entity.User;
import com.ertugrul.springboot.exception.UserNotFoundException;
import com.ertugrul.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Api üzerinden kullanıcılara erişmek için yazılmış controller sınıfı
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {

        User user = userService.findById(id);

        if (user == null) {
            throw new UserNotFoundException("User not found. id: " + id);
        }
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);

        return userDto;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }


    //2.1. Tüm kullanıcıları getiren servis.
    // http://localhost:8080/api/users
    @GetMapping(value = {"", "/"})
    public List<UserDto> findAll() {

        List<User> userList = userService.findAll();

        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUserListToUserDtoList(userList);

        return userDtoList;
    }

    //2.2. Kullanıcı adından kullanıcıyı getiren servis.
    /*Example Req: GET http://localhost:8080/api/users?username=ertugrulg */
    @GetMapping(
            value = {"", "/"},
            params = "username"
    )
    public UserDto findByUsername(@RequestParam(value = "username") String username) {

        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);

        return userDto;
    }

    //2.3. Kullanıcı telefonundan Kulanıcıyı getiren servis
    /*Example Req: GET http://localhost:8080/api/users?phone=5370540004 */
    @GetMapping(
            value = {"", "/"},
            params = "phone"
    )
    public UserDto findByPhone(@RequestParam(value = "phone") String phone) {

        User user = userService.findByPhone(phone);

        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);

        return userDto;
    }

    // 2.4. Kullanıcı kaydedilebilecek servis
    @PostMapping(value = {"", "/"})
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

    //2.5. Kullanıcı adı, ve telefon bilgileri ile kullanıcı silebilecek servis
    /*Example Req:  DELETE http://localhost:8080/api/users?username=mehmet12431&phone=5370001003*/
    @DeleteMapping(
            value = {"", "/"},
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

    //2.6. Kullanıcı bilgilerini güncelleyebilecek servis
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
}
