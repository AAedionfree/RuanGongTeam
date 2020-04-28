package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.Device;

import java.util.List;

@Mapper
public interface DevAuthDao {
    @Select("SELECT * FROM devices where dev_auth >= #{devAuth}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "devId", column = "dev_id"),
            @Result(property = "devType", column = "dev_type"),
            @Result(property = "devPrise", column = "dev_prise"),
            @Result(property = "devDate", column = "dev_date"),
            @Result(property = "devProv", column = "dev_prov"),
            @Result(property = "devPeriod", column = "dev_period"),
            @Result(property = "chargeId", column = "charge_id"),
            @Result(property = "managerId", column = "manager_id"),
            @Result(property = "devWorkStatus", column = "dev_word_status"),
            @Result(property = "devStatus", column = "dev_status"),
            @Result(property = "devAuth", column = "dev_auth")
    })
    List<Device> findDeviceByDevAuth(@Param("devAuth") int devAuth);
}
