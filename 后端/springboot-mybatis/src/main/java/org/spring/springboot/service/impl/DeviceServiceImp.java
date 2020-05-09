package org.spring.springboot.service.impl;

import org.spring.springboot.dao.devices.*;
import org.spring.springboot.dao.users.UserAccountDao;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    private DevIdDao devIdDao;
    @Autowired
    private DevManagerAccountDao devManagerAccountDao;
    @Autowired
    private DevAuthDao devAuthDao;
    @Autowired
    private UserAccountDao userAccountDao;
    @Autowired
    private DevRentDao devRentDao;
    @Autowired
    private DevUserAccountDao devUserAccountDao;
    @Autowired
    private DevRevertDao devRevertDao;

    public List<Device> findDeviceByDevId(Integer devId) throws Exception{
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if(devices.size() == 0) throw new Exception("not found DeviceID");
        return devices;
    }

    public List<Device> findDeviceByManagerAccount(String managerAccount) {
        return devManagerAccountDao.findDeviceByManagerAccount(managerAccount);
    }

    public List<Device> findDeviceByDevAuth(Integer devAuth) {
        return devAuthDao.findDeviceByDevAuth(devAuth);
    }

    public List<Device> findDeviceByUserAccount(String userAccount) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        if (users.size() == 1) {
            User user = users.get(0);
            int auth = user.getUserAuthority();
            List<Device> authDevices = findDeviceByDevAuth(auth);
            List<Device> ownDevices = findDeviceByManagerAccount(userAccount);
            authDevices.addAll(ownDevices);
            return new ArrayList<>(new HashSet<>(authDevices));
        } else if (users.size() == 0) {
            throw new Exception("userAccount not exist in DataBase");
        } else {
            throw new Exception("Duplicate userAccount in DataBase");
        }
    }

    public List<Device> lendDeviceByDevId(String userAccount, Integer devId) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if (users.size() == 1 && devices.size() == 1) {
            Device device = devices.get(0);
            int devWorkStatus = device.getDevWorkStatus();
            int devStatus = device.getDevStatus();
            if (devWorkStatus == 1 && devStatus == 1) {
                devRentDao.lendDeviceByDevId(userAccount, devId);
                return devIdDao.findDeviceBydevId(devId);
            } else {
                throw new Exception("Device can not be lend to you");
            }
        } else {
            throw new Exception("Wrong userAccount or devId");
        }
    }

    public List<Device> revertDeviceByDevId(String userAccount, Integer devId) throws Exception {
        List<User> users = userAccountDao.findUserByUserAccount(userAccount);
        List<Device> devices = devIdDao.findDeviceBydevId(devId);
        if (users.size() == 1 && devices.size() == 1) {
            Device device = devices.get(0);
            int devStatus = device.getDevStatus();
            String devUserAccount = device.getUserAccount();
            if (devStatus == 2 && devUserAccount.equals(userAccount)) {
                devRevertDao.revertDeviceByDevId(devId);
                return devIdDao.findDeviceBydevId(devId);
            } else {
                throw new Exception("Device can not be reverted");
            }
        } else {
            throw new Exception("Wrong userAccount or devId");
        }
    }

    public List<Device> findDeviceByDevUserAccount(String userAccount){
        return devUserAccountDao.findDeviceByDevUserAccount(userAccount);
    }
}
