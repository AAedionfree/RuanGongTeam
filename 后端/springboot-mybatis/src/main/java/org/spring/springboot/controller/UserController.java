package org.spring.springboot.controller;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/userAccount", method = RequestMethod.GET)
    User findUserByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount){
        return userService.findUserByUserAccount(userAccount);
    }
    @RequestMapping(value = "/api/userId", method = RequestMethod.GET)
    User findUserByUserId(@RequestParam(value = "userId", required = true) String userId){
        return userService.findUserByUserId(userId);
    }
    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    boolean findUserByUserId(@RequestParam(value = "userAccount", required = true) String userAccount ,
                                @RequestParam(value = "userPassword", required = true) String userPassword){
        return userService.findUserByUserAccount(userAccount).getUserPassword().equals(userPassword);
    }
}

//controller --> service --> dao

