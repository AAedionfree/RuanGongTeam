package org.spring.springboot.service;

import org.spring.springboot.domain.Device;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface DeviceService {

    List<Device> findDeviceByDevId(String devId);
    List<Device> findDeviceByManagerId(String managerId);
}
