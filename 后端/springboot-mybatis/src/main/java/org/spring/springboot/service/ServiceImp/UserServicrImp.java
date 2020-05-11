package org.spring.springboot.service.ServiceImp;

import org.spring.springboot.dao.users.*;
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
    @Autowired
    private UserLogoutDao userLogout;

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
    public List<User> userSignUp(Integer userId, String userAccount, String userName, String userPassword, Integer auth) throws Exception {
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        userSignUp.userSignUpTest(userId, userAccount, userName, userPassword, auth);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> userSignUp(String userAccount, String userName, String userPassword) throws Exception {
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        int id = userSignUp.getPrimayKey() + 1;
        userSignUp.userSignUp(id, userAccount, userName, userPassword);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> userSignUp(String userAccount, String userPassword) throws Exception{
        if (userSignUp.isDulicate(userAccount) == 1) throw new Exception("Duplicate-userName");
        int id = userSignUp.getPrimayKey() + 1;
        userSignUp.userSignUp(id, userAccount, "user", userPassword);
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
        List<User> users = login(userAccount, userOldPassword);
        userUpdatePassword.userUpdatePassword(userAccount, userNewPassword);
        return findUserByUserAccount(userAccount);
    }

    @Override
    public List<User> userLogout(String userAccount, String userPassword) throws Exception{
        List<User> users = login(userAccount, userPassword);
        userLogout.userLogout(userAccount);
        return users;
    }
}
