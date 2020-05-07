package org.spring.springboot.service.impl;

import org.apache.commons.collections.CollectionUtils;

import org.spring.springboot.dao.devices.DevAuthDao;
import org.spring.springboot.dao.devices.DevIdDao;
import org.spring.springboot.dao.devices.DevManagerIdDao;
import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    private DevIdDao devIdDao;
    @Autowired
    private DevManagerIdDao devManagerIdDao;
    @Autowired
    private DevAuthDao devAuthDao;
    @Autowired
    private UserAccountDao userAccountDao;

    public List<Device> findDeviceByDevId(Integer devId) throws Exception{
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if(devices.size() == 0) throw new Exception("not found DeviceID");
        return devices;
    }

    public List<Device> findDeviceByManagerId(Integer managerId) {
        return devManagerIdDao.findDeviceByManagerId(managerId);
    }

    public List<Device> findDeviceByDevAuth(Integer devAuth) {
        return devAuthDao.findDeviceByDevAuth(devAuth);
    }

    public List<Device> findDeviceByUserAccount(String userAccount) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        if (users.size() == 1) {
            User user = users.get(0);
            int auth = user.getUserAuthority();
            int userId = user.getUserId();
            List<Device> authDevices = findDeviceByDevAuth(auth);
            List<Device> ownDevices = findDeviceByManagerId(userId);
            authDevices.addAll(ownDevices);
            return new ArrayList<>(new HashSet<>(authDevices));
        } else if (users.size() == 0) {
            throw new Exception("userAccount not exist in DataBase");
        } else {
            throw new Exception("Duplicate userAccount in DataBase");
        }
    }
}
