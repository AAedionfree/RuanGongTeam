package org.spring.springboot.controller;

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

    @RequestMapping(value = "/api/userAccount", method = RequestMethod.GET)
    ResultBean<User> findUserByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) throws RuntimeException{
        List<User> ans = userService.findUserByUserAccount(userAccount);
        if(ans.size() == 0) return ResultBean.error(-1,"not found UserAccount");
        return ResultBean.success(ans);
    }
    @RequestMapping(value = "/api/userId", method = RequestMethod.GET)
    ResultBean<User> findUserByUserId(@RequestParam(value = "userId", required = true) String userId) throws RuntimeException{
        List<User> ans = userService.findUserByUserId(userId);
        if(ans.size() == 0) return ResultBean.error(-1,"not found UserID");
        return ResultBean.success(ans);
    }
    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    ResultBean findUserByUserId(@RequestParam(value = "userAccount", required = true) String userAccount ,
                                @RequestParam(value = "userPassword", required = true) String userPassword) throws RuntimeException{
        ResultBean<User> userByUserAccount = findUserByUserAccount(userAccount);
        if(ResultBean.IsSuccess(userByUserAccount)){
            if(new ArrayList<User>(userByUserAccount.getData()).get(0).getUserPassword().equals(userPassword))
                return ResultBean.success();
            else
                return ResultBean.error(-1, "Wrong password");
        }
        else return userByUserAccount;
    }
}


