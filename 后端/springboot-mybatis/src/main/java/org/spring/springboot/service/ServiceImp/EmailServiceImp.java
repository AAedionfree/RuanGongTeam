package org.spring.springboot.service.ServiceImp;

import org.spring.springboot.dao.emails.EmailBindDao;
import org.spring.springboot.dao.emails.EmailUnbindDao;
import org.spring.springboot.dao.emails.EmailUserAccountDao;
import org.spring.springboot.dao.emails.EmailUpdateDao;
import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.domain.Email;
import org.spring.springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImp implements EmailService {
    @Autowired
    UserAccountDao userAccountDao;

    @Autowired
    EmailBindDao emailBindDao;

    @Autowired
    EmailUnbindDao emailUnbindDao;

    @Autowired
    EmailUpdateDao emailUpdateDao;

    @Autowired
    EmailUserAccountDao emailUserAccountDao;

    @Autowired
    UserServicrImp userServicrImp;

    private void checkPassword(String userAccount, String inputPassword) throws Exception{
        String realPassword = userServicrImp.findUserByUserAccount(userAccount).get(0).getUserPassword();
        if(!realPassword.equals(inputPassword)){
            throw new Exception("Wrong password");
        }
    }

    @Override
    public List<Email> bindEmail(String userAccount, String userPassword, String emailAddress) throws Exception{
        checkPassword(userAccount, userPassword);
        emailUpdateDao.updateEmailAddress(userAccount,emailAddress);
        return null;
    }

    @Override
    public List<Email> unbindEmail(String userAccount, String userPassword) throws Exception{
        checkPassword(userAccount, userPassword);
        emailUnbindDao.unbindEmailAddress(userAccount);
        return null;
    }

    @Override
    public List<Email> findEmailByUserAccount(String userAccount) throws Exception{
        return emailUserAccountDao.findEmailByUserAccount(userAccount);
    }

    @Override
    public List<Email> updateEmail(String userAccount, String userPassword, String emailAddress) throws Exception{
        checkPassword(userAccount, userPassword);
        emailUpdateDao.updateEmailAddress(userAccount, emailAddress);
        return null;
    }
}
