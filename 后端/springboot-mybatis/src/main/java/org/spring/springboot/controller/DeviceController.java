package org.spring.springboot.controller;

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

    @RequestMapping(value = "/api/device", method = RequestMethod.GET)
    public List<Device> findDeviceByDevId(@RequestParam(value = "devId", required = true) String devId){
        return deviceService.findDeviceByDevId(devId);
    }


}
