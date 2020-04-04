package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.City;

import java.util.List;

public interface ProvinceIdDao {
    @Select("SELECT * FROM city where province_id = #{provinceId}")
    // 返回 Map 结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    List<City> findByProvinceId(String provinceId);
}
