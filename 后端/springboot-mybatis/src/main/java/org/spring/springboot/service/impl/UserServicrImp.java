package org.spring.springboot.service.impl;

import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicrImp implements UserService {
    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    public List<User> findUserByUserAccount(String userAccount) {
        return userAccountDao.findUserByUserAccount(userAccount);
    }
}
