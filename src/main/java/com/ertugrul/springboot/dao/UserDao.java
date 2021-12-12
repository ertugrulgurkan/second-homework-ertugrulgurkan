package com.ertugrul.springboot.dao;

import com.ertugrul.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByPhone(String username);

    Optional<User> findByPhoneAndUsername(String phone, String username);
}
