package org.spring.springboot.service.impl;

import org.spring.springboot.ResultBean;
import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.dao.users.UserSignUp;
import org.spring.springboot.dao.users.UserIdDao;
import org.spring.springboot.dao.users.UserUpdatePassword;
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
    @Autowired
    private UserUpdatePassword userUpdatePassword;

    @Override
    public List<User> findUserByUserAccount(String userAccount) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        if (users.size() == 0) throw new Exception("UserAccount not Exist in DataBase");
        return users;
    }

    @Override
    public List<User> findUserByUserId(Integer userId) throws Exception {
        List<User> users = userIdDao.findUserByUserId(userId);
        if (users.size() == 0) throw new Exception("UserId not Exist in DataBase");
        return users;
    }

    @Override
    public List<User> userSignUp(String userAccount, String userName, String userPassword) throws Exception {
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        int id = Integer.parseInt(userSignUp.getPrimayKey()) + 1;
        userSignUp.userSignUP(id, userAccount, userName, userPassword);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> userSignUp(String userAccount, String userPassword) throws Exception{
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        int id = Integer.parseInt(userSignUp.getPrimayKey()) + 1;
        userSignUp.userSignUP(id, userAccount, "user", userPassword);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> login(String userAccount, String userPassword) throws Exception{
        List<User> userByUserAccount = findUserByUserAccount(userAccount);
        if(userByUserAccount.get(0).getUserPassword().equals(userPassword)){
            return userByUserAccount;
        }else{
            throw new Exception("Wrong password");
        }
    }

    @Override
    public List<User> userUpdatePassword(String userAccount, String userOldPassword, String userNewPassword) throws Exception{
        List<User> userByUserAccount = findUserByUserAccount(userAccount);
        if (userUpdatePassword.isPasswordRight(userAccount, userOldPassword) == 0) throw new Exception("Wrong-userPassword");
        userUpdatePassword.userUpdatePassword(userAccount, userNewPassword);
        return userByUserAccount;
    }
}
