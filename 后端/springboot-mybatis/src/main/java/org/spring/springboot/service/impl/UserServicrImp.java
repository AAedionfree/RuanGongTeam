package org.spring.springboot.service.impl;

import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.dao.users.UserSignUp;
import org.spring.springboot.dao.users.UserIdDao;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicrImp implements UserService {
    @Autowired
    private UserAccountDao userAccountDao;
    @Autowired
    private UserIdDao userIdDao;
    @Autowired
    private UserSignUp userSignUp;

    @Override
    public List<User> findUserByUserAccount(String userAccount) {
        return userAccountDao.findUserByUserAccount(userAccount);
    }
    @Override
    public List<User> findUserByUserId(String userId) {
        return userIdDao.findUserByUserId(userId);
    }

    @Override
    public boolean userSignUp(String userAccount, String userName, String userPassword) {
        if(userSignUp.isDulicate(userAccount) == 1) return false;
        String id = Integer.parseInt(userSignUp.getPrimayKey()) + 1 + "";
        userSignUp.userSignUP(id,userAccount,userName,userPassword);
        return true;
    }

    @Override
    public boolean userSignUp(String userAccount, String userPassword) {
        if(userSignUp.isDulicate(userAccount) == 1) return false;
        String id = Integer.parseInt(userSignUp.getPrimayKey()) + 1 + "";
        userSignUp.userSignUP(id,userAccount,"user",userPassword);
        return true;
    }
}
