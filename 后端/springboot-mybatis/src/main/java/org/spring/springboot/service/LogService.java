package org.spring.springboot.service;

import org.spring.springboot.domain.Log;

import java.util.List;

public interface LogService extends Service{
    List<Log> findAllLogs();
    List<Log> findLogsByUserId(Integer UserId);
}
