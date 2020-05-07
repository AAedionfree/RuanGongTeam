package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DevChangeDao {
    @Update("update devices set user_account = #{userAccount} where dev_id = #{devId}")
    void lendDeviceByDevId(@Param("userAccount") String userAccount,
                        @Param("devId") int devId);
    
}

