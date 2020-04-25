package org.spring.springboot.controller;

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
    public ResultBean<Device> findDeviceByDevId(@RequestParam(value = "devId", required = true) String devId){
        List<Device> devices = deviceService.findDeviceByDevId(devId);
        if(devices.size() == 0) return ResultBean.error(devId,-1,"not found DeviceID");
        return ResultBean.success(devId, devices);
    }

    // find devInfo by ManagerId
    @RequestMapping(value = "/api/devManagerId", method = RequestMethod.GET)
    public ResultBean<Device> findDeviceByManagerId(@RequestParam(value = "ManagerId", required = true) String managerId){
        List<Device> devices = deviceService.findDeviceByManagerId(managerId);
        return ResultBean.success(managerId,devices);
    }
}
