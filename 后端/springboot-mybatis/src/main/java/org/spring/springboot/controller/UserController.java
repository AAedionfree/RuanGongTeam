package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.HttpClient;
import org.spring.springboot.ResultBean;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // find userInfo by userAccount
    @RequestMapping(value = "/api/userAccount", method = RequestMethod.GET)
    public ResultBean<User> findUserByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) throws RuntimeException {
        return ExceptionCatch.exceptionCatch(userService,userAccount,userAccount);
    }

    //  find userInfo by userId
    @RequestMapping(value = "/api/userId", method = RequestMethod.GET)
    public ResultBean<User> findUserByUserId(@RequestParam(value = "userId", required = true) int userId) throws RuntimeException {
        return ExceptionCatch.exceptionCatch(userService,userId + "", new Integer(userId));
    }

    //  login
    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    public ResultBean login(@RequestParam(value = "userAccount", required = true) String userAccount,
                     @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(userService,userAccount, userAccount,userPassword);
    }
    // register

    /**
     * The legality of password should checked in mid
     * just check the legality of userAccount legality
     */
    @RequestMapping(value = "/api/register", method = RequestMethod.GET)
    public ResultBean userSignUp(@RequestParam(value = "userAccount", required = true) String userAccount,
                          @RequestParam(value = "userName", required = true) String userName,
                          @RequestParam(value = "userPassword", required = true) String userPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userName, userPassword);
    }

    //  update user password
    @RequestMapping(value = "/api/userUpdatePassword", method = RequestMethod.GET)
    public ResultBean userUpdatePassword(@RequestParam(value = "userAccount", required = true) String userAccount,
                                  @RequestParam(value = "userOldPassword", required = true) String userOldPassword,
                                  @RequestParam(value = "userNewPassword", required = true) String userNewPassword) {
        return ExceptionCatch.exceptionCatch(userService, userAccount, userAccount, userOldPassword, userNewPassword);
    }

}


