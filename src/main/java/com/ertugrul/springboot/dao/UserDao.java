package com.ertugrul.springboot.dao;

import com.ertugrul.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    Optional<User> findByPhone(String userName);
    Optional<User> findByPhoneAndUserName(String phone,String userName);
}
