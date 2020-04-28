package org.spring.springboot.service;

import org.spring.springboot.domain.User;

import java.util.List;

public interface UserService extends Service{
    List<User> findUserByUserAccount(String userId) throws Exception;
    List<User> findUserByUserId(Integer userId) throws Exception;
    List<User> userSignUp(String userAccount, String userName, String userPassword) throws Exception;
    List<User> userSignUp(String userAccount, String userPassword) throws Exception;
    List<User> login(String userAccount, String userPassword) throws Exception;
}
