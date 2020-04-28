package org.spring.springboot.controller;

import org.spring.springboot.ExceptionCatch;
import org.spring.springboot.ResultBean;
import org.spring.springboot.domain.Device;
import org.spring.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    // find devInfo by devId
    @RequestMapping(value = "/api/devId", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByDevId(@RequestParam(value = "devId", required = true) String devId) {
        return ExceptionCatch.exceptionCatch(deviceService, devId, devId);
    }

    // find devInfo by ManagerId
    @RequestMapping(value = "/api/devManagerId", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByManagerId(@RequestParam(value = "managerId", required = true) int managerId) {
        return ExceptionCatch.exceptionCatch(deviceService, managerId + "", managerId);
    }

    // find devInfo by userAuth
    @RequestMapping(value = "/api/devAuth", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByDevAuth(@RequestParam(value = "devAuth", required = true) int devAuth) {
        return ExceptionCatch.exceptionCatch(deviceService, "devAuth:" + devAuth, new Integer(devAuth));
    }

    // find devInfo by userAccount
    @RequestMapping(value = "/api/devUserAccount", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByUserAccount(@RequestParam(value = "userAccount", required = true) String userAccount) {
        return ExceptionCatch.exceptionCatch(deviceService, userAccount,userAccount);
    }
}
