package org.spring.springboot.dao.users;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.User;

import java.util.List;

public interface UserLogoutDao {
    @Delete("DELETE FROM users where user_account = #{userAccount}")
<<<<<<< HEAD
    // 返回 Map 结果集
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userAccount", column = "user_account"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "userAuthority", column = "user_authority")
    })
=======
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
    void userLogout(@Param("userAccount") String userAccount);
}
