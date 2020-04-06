package org.spring.springboot.service.impl;

import org.spring.springboot.dao.devices.DevIdDao;
import org.spring.springboot.domain.Device;
import org.spring.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    private DevIdDao devIdDao;

    public List<Device> findDeviceByDevId(String devId){
        return devIdDao.findDeviceBydevId(devId);
    }
}
