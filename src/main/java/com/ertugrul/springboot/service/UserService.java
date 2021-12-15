package com.ertugrul.springboot.service;

import com.ertugrul.springboot.dao.UserDao;
import com.ertugrul.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Kullanıcılar ile ilgili dataya controllerdan erişebilmek için yazılmış Servis.
@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userDao.findById(id);

        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        return user;
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userDao.findByUsername(username);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }

    public User findByPhone(String phone) {
        Optional<User> optionalUser = userDao.findByPhone(phone);

        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        return user;
    }

    public User findByPhoneAndUserName(String phone, String username) {
        Optional<User> optionalUser = userDao.findByPhoneAndUsername(phone, username);

        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        return user;
    }

    public User save(User user) {
        user = userDao.save(user);

        return user;
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    public long count() {
        return userDao.count();
    }

}
