package org.spring.springboot.service;

import org.spring.springboot.domain.Log;

import java.util.List;

public interface LogService {
    List<Log> findAllLogs();
}
