package org.spring.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.domain.City;

import java.util.ArrayList;
import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Mapper
public interface CityDao {

    @Select("SELECT * FROM city where city_name = #{cityName}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    List<City> findByName(@Param("cityName") String cityName);
}
