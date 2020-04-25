package org.spring.springboot.service;

import org.spring.springboot.domain.Log;

import java.util.List;

public interface LogService {
    List<Log> findAllLogs();
    List<Log> findLogsByUserId(String UserId);
}
