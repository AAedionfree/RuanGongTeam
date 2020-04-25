package org.spring.springboot.controller;

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
    ResultBean<User> findUserByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) throws RuntimeException {
        List<User> ans = userService.findUserByUserAccount(userAccount);
        if (ans.size() == 0)
            return ResultBean.error(userAccount, -1, "not found UserAccount");
        return ResultBean.success(userAccount, ans);
    }

    //  find userInfo by userId
    @RequestMapping(value = "/api/userId", method = RequestMethod.GET)
    ResultBean<User> findUserByUserId(@RequestParam(value = "userId", required = true) String userId) throws RuntimeException {
        List<User> ans = userService.findUserByUserId(userId);
        if (ans.size() == 0) return ResultBean.error(userId, -1, "not found UserID");
        return ResultBean.success(userId, ans);
    }

    //  login
    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    ResultBean login(@RequestParam(value = "userAccount", required = true) String userAccount,
                     @RequestParam(value = "userPassword", required = true) String userPassword) throws Exception {
        ResultBean<User> userByUserAccount = findUserByUserAccount(userAccount);
        ResultBean ans = userByUserAccount;
        if (ResultBean.IsSuccess(userByUserAccount)) {
            if (new ArrayList<User>(userByUserAccount.getData()).get(0).getUserPassword().equals(userPassword))
                ans = ResultBean.success(userAccount);
            else
                ans = ResultBean.error(userAccount, -1, "Wrong password");
        }
        return ans;
    }

    // register
    /**
     * password's legality checked in mid
     * just check userAccount's legality
     */
//    @RequestMapping(value = "/api/register", method = RequestMethod.GET)
//    ResultBean register(@RequestParam(value = "userAccount", required = true) String userAccount ,
//                     @RequestParam(value = "userPassword", required = true) String userPassword) throws RuntimeException{
//        ResultBean<User> userByUserAccount = findUserByUserAccount(userAccount);
//        if(ResultBean.IsSuccess(userByUserAccount)){
//            if(new ArrayList<User>(userByUserAccount.getData()).get(0).getUserPassword().equals(userPassword))
//                return ResultBean.success();
//            else
//                return ResultBean.error(-1, "Wrong password");
//        }
//        else return userByUserAccount;
//    }

}


