package org.spring.springboot.domain;

public class User {
    String userId;
    String userName;
    String userAccount;
    String userPassword;
    int userAuthority;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(int userAuthority) {
        this.userAuthority = userAuthority;
    }
}
