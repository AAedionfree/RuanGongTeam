package org.spring.springboot.service.impl;

import org.spring.springboot.dao.devices.DevIdDao;
import org.spring.springboot.dao.devices.DevWorkStatusDao;
import org.spring.springboot.dao.logs.LogsAddFixRecordDao;
import org.spring.springboot.dao.logs.LogsDao;
import org.spring.springboot.dao.logs.LogsUserAccountDao;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Log;
import org.spring.springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogSeriviceImp implements LogService {
    @Autowired
    private LogsDao logsDao;

    @Autowired
    private LogsUserAccountDao logsUserAccountDao;

    @Autowired
    private DevIdDao devIdDao;

    @Autowired
    private DevWorkStatusDao devWorkStatusDao;

    @Autowired
    private LogsAddFixRecordDao logsAddFixRecordDao;

    @Override
    public List<Log> findAllLogs() {
        return logsDao.findAllLogs();
    }

    @Override
    public List<Log> findLogsByUserAccount(String userAccount) {
        return logsUserAccountDao.findLogsByUserAccount(userAccount);
    }

    private void addBasicRecord(String userAccount, Integer devId, int startStatus, int nextStatus) throws Exception{
        String date = new Date().toString();
        Device device = devIdDao.findDeviceBydevId(devId).get(0);
        int logId = logsAddFixRecordDao.getPrimayKey() + 1;
        int deviceStatus = device.getDevStatus();
        int deviceWorkStatus = device.getDevWorkStatus();
        int auth = device.getDevAuth();
        if (!device.getUserAccount().equals(userAccount) && !device.getChargeAccount().equals(userAccount)) {
            throw new Exception("Authentication failed " + userAccount);
        }
        if (deviceWorkStatus != startStatus) {
            throw new Exception("Can't fix device with devStatus:" + device.getDevWorkStatus());
        }
        logsAddFixRecordDao.logsAddFixRecord(logId, devId, deviceStatus, deviceWorkStatus,
                3, 1, userAccount, device.getManagerAccount(), date, auth);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, nextStatus);
    }

    @Override
    public List<Log> addFixLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount,devId,3,1);
        return null;
    }

    @Override
    public List<Log> addDamageLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount,devId,1,3);
        return null;
    }
}
