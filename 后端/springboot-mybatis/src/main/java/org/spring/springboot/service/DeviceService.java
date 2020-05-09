package org.spring.springboot.service;

import org.spring.springboot.domain.Device;

import java.util.List;

public interface DeviceService extends Service{

    List<Device> findDeviceByDevId(Integer devId) throws Exception;
    List<Device> findDeviceByManagerAccount(String managerAccount);
    List<Device> findDeviceByDevAuth(Integer devAuth);
    List<Device> findDeviceByUserAccount(String userAccount) throws Exception;
    List<Device> lendDeviceByDevId(String userAccount, Integer devId) throws Exception;
    List<Device> findDeviceByDevUserAccount(String userAccount);
}
