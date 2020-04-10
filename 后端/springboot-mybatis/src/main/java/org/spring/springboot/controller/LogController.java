package org.spring.springboot.controller;

import org.spring.springboot.domain.Log;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/api/logs", method = RequestMethod.GET)
    List<Log> findUserByUserAccount(){
        return logService.findAllLogs();
    }
}
