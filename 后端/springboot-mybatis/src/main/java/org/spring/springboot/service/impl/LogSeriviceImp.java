package org.spring.springboot.service.impl;

import org.spring.springboot.dao.logs.LogsDao;
import org.spring.springboot.domain.Log;
import org.spring.springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogSeriviceImp implements LogService {
    @Autowired
    private LogsDao logsDao;


    @Override
    public List<Log> findAllLogs() {
        return logsDao.findAllLogs();
    }
}
