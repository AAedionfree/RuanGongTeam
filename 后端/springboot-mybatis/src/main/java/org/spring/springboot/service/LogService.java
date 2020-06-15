package org.spring.springboot.service;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Log;

import java.util.List;

public interface LogService extends Service {
    List<Log> findAllLogs();

    List<Log> findLogsByUserAccount(String userAccount);

    List<Log> addFixLog(String userAccount, Integer devId) throws Exception;

    List<Log> addDamageLog(String userAccount, Integer devId) throws Exception;

    List<Log> addScrapLog(String userAccount, Integer devId) throws Exception;

    List<Log> findScrapLog(String userAccount) throws Exception;

    List<Log> dealScrapLog(String userAccount, Integer logId, Integer logStatus) throws Exception;

    List<Log> cancelRecord(String userAccount, Integer logId, Integer logStatus) throws Exception;

}
