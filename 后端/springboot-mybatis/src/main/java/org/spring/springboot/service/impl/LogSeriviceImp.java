package org.spring.springboot.service.impl;

import org.spring.springboot.dao.logs.LogsDao;
import org.spring.springboot.dao.logs.LogsUserIdDao;
import org.spring.springboot.domain.Log;
import org.spring.springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogSeriviceImp implements LogService {
    @Autowired
    private LogsDao logsDao;

    @Autowired
    private LogsUserIdDao logsUserIdDao;

    @Override
    public List<Log> findAllLogs() {
        return logsDao.findAllLogs();
    }

    @Override
<<<<<<< HEAD
    public List<Log> findLogsByUserId(int UserId){ return logsUserIdDao.findLogsByUserId(UserId);}
=======
    public List<Log> findLogsByUserId(Integer UserId){ return logsUserIdDao.findLogsByUserId(UserId);}
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
}
