package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.dao.logs.LogsUserIdDao;
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

    //  find all logs
    @RequestMapping(value = "/api/logs", method = RequestMethod.GET)
<<<<<<< HEAD
    ResultBean<Log> findAllLogs() {
=======
    public ResultBean<Log> findAllLogs() {
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
        return ExceptionCatch.exceptionCatch(logService, "AllLogs");
    }

    //  find logs by userId
    @RequestMapping(value = "/api/userLogs", method = RequestMethod.GET)
<<<<<<< HEAD
    ResultBean<Log> findLogsByUserId(@RequestParam(value = "userId", required = true) int userId) {
=======
    public ResultBean<Log> findLogsByUserId(@RequestParam(value = "userId", required = true) int userId) {
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
        return ExceptionCatch.exceptionCatch(logService, userId + "", new Integer(userId));
    }
}