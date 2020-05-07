package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.Device;

import java.util.List;

public interface DevManagerIdDao {

    @Select("SELECT * FROM devices where manager_id = #{managerId}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "devId", column = "dev_id"),
            @Result(property = "devName", column = "dev_name"),
            @Result(property = "devType", column = "dev_type"),
            @Result(property = "devPrise", column = "dev_prise"),
            @Result(property = "devDate", column = "dev_date"),
            @Result(property = "devPeriod", column = "dev_period"),
            @Result(property = "chargeId", column = "charge_id"),
            @Result(property = "managerId", column = "manager_id"),
            @Result(property = "devWorkStatus", column = "dev_work_status"),
            @Result(property = "devStatus", column = "dev_status"),
            @Result(property = "devAuth", column = "dev_auth"),
            @Result(property = "userAccount", column = "user_account")
    })
    List<Device> findDeviceByManagerId(@Param("managerId") int managerId);
}
