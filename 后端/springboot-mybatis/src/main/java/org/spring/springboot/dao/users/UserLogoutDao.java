package org.spring.springboot.dao.users;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.User;

import java.util.List;

public interface UserLogoutDao {
    @Delete("DELETE FROM users where user_account = #{userAccount}")
    void userLogout(@Param("userAccount") String userAccount);
}
