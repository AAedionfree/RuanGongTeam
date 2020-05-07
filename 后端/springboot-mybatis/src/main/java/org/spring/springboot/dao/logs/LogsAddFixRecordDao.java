package org.spring.springboot.dao.logs;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface LogsAddFixRecordDao {
    @Select("select log_id from logs order by log_id desc limit 1")
    @ResultType(Integer.class)
    Integer getPrimayKey();

    @Insert("insert into logs value(#{logId}, #{devId}, #{devStatus}, #{devWorkStatus}, #{tokenId}, #{tokenStatus}, #{senderAccount}, #{receiverAccount}, #{changeTime}, #{auth})")
    void logsAddFixRecord(@Param("logId") int logId,
                          @Param("devId") int devId,
                          @Param("devStatus") int devStatus,
                          @Param("devWorkStatus") int devWorkStatus,
                          @Param("tokenId") int tokenId,
                          @Param("tokenStatus") int tokenStatus,
                          @Param("senderAccount") String senderAccount,
                          @Param("receiverAccount") String receiverAccount,
                          @Param("changeTime") String changeTime,
                          @Param("auth") int auth
                          );
}
