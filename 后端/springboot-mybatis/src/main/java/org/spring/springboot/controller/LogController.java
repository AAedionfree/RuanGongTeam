package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Log;
import org.spring.springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @Autowired
    private LogService logService;

    //  find all logs
    @RequestMapping(value = "/api/logs", method = RequestMethod.GET)
    public ResultBean<Log> findAllLogs() {
        return ExceptionCatch.exceptionCatch(logService, "AllLogs");
    }

    //  find logs by userId
    @RequestMapping(value = "/api/userLogs", method = RequestMethod.GET)
    public ResultBean<Log> findLogsByUserAccount(@RequestParam(value = "userId", required = true) String userAccount) {
        return ExceptionCatch.exceptionCatch(logService, userAccount, userAccount);
    }

    // add Fix record
    @RequestMapping(value = "/api/devAddFixRecord", method = RequestMethod.GET)
    public ResultBean addFixLog(
            @RequestParam(value = "userAccount", required = true) String userAccount ,
            @RequestParam(value = "devId", required = true) int devId
    ) {
        return ExceptionCatch.exceptionCatch(logService, devId + "", userAccount, new Integer(devId));
    }

    // add damage record
    @RequestMapping(value = "/api/devAddDamageRecord", method = RequestMethod.GET)
    public ResultBean addDamageLog(
            @RequestParam(value = "userAccount", required = true) String userAccount ,
            @RequestParam(value = "devId", required = true) int devId
    ) {
        return ExceptionCatch.exceptionCatch(logService, devId + "", userAccount, new Integer(devId));
    }
}