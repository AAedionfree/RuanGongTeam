package org.spring.springboot.service;

import org.spring.springboot.domain.User;

import java.util.List;

public interface UserService {
    User findUserByUserAccount(String userId);
    User findUserByUserId(String userId);
}
