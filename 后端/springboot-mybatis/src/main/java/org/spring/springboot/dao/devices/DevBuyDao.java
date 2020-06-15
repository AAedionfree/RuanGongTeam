package org.spring.springboot.dao.devices;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DevBuyDao {
    @Select("select dev_id from devices order by dev_id desc limit 1")
    @ResultType(Integer.class)
    Integer getPrimayKey();

    @Select("select dev_id from devicesTemp order by dev_id desc limit 1")
    @ResultType(Integer.class)
    Integer getTempPrimayKey();

    @Insert("insert into devices value(#{devId}, #{devName}, #{devType}, #{devPrise}, #{devDate}, #{devPeriod}, " +
            "#{chargeAccount}, null, #{managerAccount}, 1, 1, #{devAuth})")
    void buyDeviceByDevInfo(@Param("devId") int devId,
                            @Param("devName") String devName,
                            @Param("devType") String devType,
                            @Param("devPrise") float devPrise,
                            @Param("devDate") String devDate,
                            @Param("devPeriod") String devPeriod,
                            @Param("chargeAccount") String chargeAccount,
                            @Param("managerAccount") String managerAccount,
                            @Param("devAuth") int devAuth);

    @Insert("insert into devicesTemp value(#{devId}, #{devName}, #{devType}, #{devPrise}, #{devDate}, #{devPeriod}, " +
            "#{chargeAccount}, null, null, 1, 1, #{devAuth})")
    void buyDeviceTempByDevInfo(@Param("devId") int devId,
                            @Param("devName") String devName,
                            @Param("devType") String devType,
                            @Param("devPrise") float devPrise,
                            @Param("devDate") String devDate,
                            @Param("devPeriod") String devPeriod,
                            @Param("chargeAccount") String chargeAccount,
                            @Param("devAuth") int devAuth);
}
