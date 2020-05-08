package org.spring.springboot.dao.logs;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.spring.springboot.domain.Log;

import java.util.List;

public interface LogsScrapRecordDao {
    @Select("SELECT * FROM logs where token_id=5")
    // 返回 Map 结果集
    @Results({
            @Result(property = "logId", column = "log_id"),
            @Result(property = "devId", column = "dev_id"),
            @Result(property = "devStatus", column = "dev_status"),
            @Result(property = "devWorkStatus", column = "dev_work_status"),
            @Result(property = "tokenId", column = "token_id"),
            @Result(property = "tokenStatus", column = "token_status"),
            @Result(property = "senderAccount", column = "sender_Account"),
            @Result(property = "receiverAccount", column = "receiver_Account"),
            @Result(property = "changeTime", column = "change_time"),
            @Result(property = "auth", column = "auth")
    })
    List<Log> findScrapRecord();
}
