package org.spring.springboot.service;

import org.spring.springboot.domain.Device;

import java.util.List;

public interface DeviceService extends Service{

    List<Device> findDeviceByDevId(Integer devId) throws Exception;
    List<Device> findDeviceByManagerId(Integer managerId);
    List<Device> findDeviceByDevAuth(Integer devAuth);
<<<<<<< HEAD
    List<Device> findDeviceByUserAccount(String userAccount) throws Exception;
    List<Device> lendDeviceByDevId(String userAccount, Integer devId) throws Exception;
=======
    List<Device> findDeviceByUserAccount(String devAuth) throws Exception;
>>>>>>> cbae7016019df2da6e792365c3276cca1f782097
}
