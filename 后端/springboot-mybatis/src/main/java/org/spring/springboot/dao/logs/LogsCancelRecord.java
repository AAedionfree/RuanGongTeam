package org.spring.springboot.dao.logs;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LogsCancelRecord {
    @Update("update logs set token_status = 4 where log_id = #{logId}")
    void cancelRecord(@Param("logId") int logId);
}
