package org.spring.springboot.dao.users;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.User;

import java.util.List;

@Mapper
public interface UserSignUp {
    @Select("select user_id from users order by user_id desc limit 1")
    @ResultType(Integer.class)
    String getPrimayKey();

    @Select("select Count(*) from users where user_account = #{userAccount} limit 1")
    @ResultType(Integer.class)
    int isDulicate(@Param("userAccount") String userAccount);

    @Insert("insert into users value(#{userId}, #{userName}, #{userAccount}, #{userPassword}, 3)")
    void userSignUP(@Param("userId") String userId,
                    @Param("userName") String userName,
                    @Param("userAccount") String userAccount,
                    @Param("userPassword") String userPassword);
}