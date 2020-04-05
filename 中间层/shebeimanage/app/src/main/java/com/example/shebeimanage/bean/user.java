package com.example.shebeimanage.bean;

import cn.bmob.v3.BmobUser;

public class user extends BmobUser {
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public user setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
}
