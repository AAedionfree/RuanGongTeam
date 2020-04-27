package org.spring.springboot.service;

import org.spring.springboot.domain.User;

import java.util.List;

public interface UserService {
    List<User> findUserByUserAccount(String userId);
    List<User> findUserByUserId(String userId);
    boolean userSignUp(String userAccount, String userName, String userPassword);
    boolean userSignUP(String userAccount, String userPassword);
}
