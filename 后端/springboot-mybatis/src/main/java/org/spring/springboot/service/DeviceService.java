package org.spring.springboot.service;

import org.spring.springboot.domain.Device;

import java.util.List;

public interface DeviceService extends Service{

    List<Device> findDeviceByDevId(Integer devId) throws Exception;
    List<Device> findDeviceByManagerId(Integer managerId);
    List<Device> findDeviceByDevAuth(Integer devAuth);
    List<Device> findDeviceByUserAccount(String devAuth) throws Exception;
}
