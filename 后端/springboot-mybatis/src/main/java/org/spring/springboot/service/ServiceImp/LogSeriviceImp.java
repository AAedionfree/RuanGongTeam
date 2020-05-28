package org.spring.springboot.service.ServiceImp;

import org.spring.springboot.dao.devices.DevIdDao;
import org.spring.springboot.dao.devices.DevWorkStatusDao;
import org.spring.springboot.dao.logs.*;
import org.spring.springboot.dao.users.UserAccountDao;
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
    private UserAccountDao userAccountDao;

    @Autowired
    private LogsScrapRecordDao logsScrapRecordDao;

    @Autowired
    private LogsDao logsDao;

    @Autowired
    private LogsIdDao logsIdDao;

    @Autowired
    private LogsUserAccountDao logsUserAccountDao;

    @Autowired
    private DevIdDao devIdDao;

    @Autowired
    private DevWorkStatusDao devWorkStatusDao;

    @Autowired
    private LogsAddBasicRecordDao logsAddBasicRecordDao;

    @Autowired
    private LogsCancelRecord logsCancelRecord;

    @Override
    public List<Log> findAllLogs() {
        return logsDao.findAllLogs();
    }

    @Override
    public List<Log> findLogsByUserAccount(String userAccount) {
        return logsUserAccountDao.findLogsByUserAccount(userAccount);
    }

    private void addBasicRecord(String userAccount, Integer devId, int tokenId, int startStatus, int nextStatus, int tokenStatus) throws Exception {
        String date = new Date().toString();
        Device device = devIdDao.findDeviceBydevId(devId).get(0);
        int logId = logsAddBasicRecordDao.getPrimayKey() + 1;
        int deviceStatus = device.getDevStatus();
        int deviceWorkStatus = device.getDevWorkStatus();
        int auth = device.getDevAuth();
        if ((device.getUserAccount() != null && !device.getUserAccount().equals(userAccount)) && !device.getChargeAccount().equals(userAccount)) {
            throw new Exception("Authentication failed " + userAccount);
        }
        if (deviceWorkStatus != startStatus) {
            throw new Exception("Can't deal device with devStatus:" + device.getDevWorkStatus());
        }
        logsAddBasicRecordDao.logsAddBasicRecord(logId, devId, deviceStatus, deviceWorkStatus,
                tokenId, tokenStatus, userAccount, device.getManagerAccount(), date, auth);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId, nextStatus);
    }
/*
    @Override List<Log> addLendLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount, devId, 1, 1, 2, 1);
        return null;
    }
*/

    @Override
    public List<Log> addFixLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount, devId, 3, 3, 1, 1);
        return null;
    }

    @Override
    public List<Log> addDamageLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount, devId, 4, 1, 3, 1);
        return null;
    }

    @Override
    public List<Log> addScrapLog(String userAccount, Integer devId) throws Exception {
        addBasicRecord(userAccount, devId, 5, 3, 5, 3);
        return null;
    }

    @Override
    public List<Log> findScrapLog(String userAccount) throws Exception {
        int auth = userAccountDao.findUserByUserAccount(userAccount).get(0).getUserAuthority();
        if (auth > 0) {
            throw new Exception("Authentication failed with UserAuthority:" + auth);
        }
        return logsScrapRecordDao.findScrapRecord();
    }

    @Override
    public List<Log> dealScrapLog(String userAccount, Integer logId, Integer logStatus) throws Exception {
        String date = new Date().toString();
        if (logStatus != 1 && logStatus != 2){
            throw new Exception("logStatus only can be 1 or 2 but received:" + logStatus);
        }
        int userAuth = userAccountDao.findUserByUserAccount(userAccount).get(0).getUserAuthority();
        if (userAuth > 0) {
            throw new Exception("Authentication user failed with UserAuthority:" + userAuth);
        }
        Log log = logsIdDao.findLogsByLogId(logId).get(0);
        int logNowStatus = log.getTokenStatus();
        int devId = log.getDevId();
        if (logNowStatus != 3) {
            throw new Exception("Authentication Log Status failed with:" + logNowStatus);
        }
        logsScrapRecordDao.dealScrapRecord(logId,logStatus);
        devWorkStatusDao.updateDevWorkStatusByDevId(devId,logStatus == 2?3:2);
        int id = logsAddBasicRecordDao.getPrimayKey() + 1;
        logsAddBasicRecordDao.logsAddBasicRecord(id, devId, -1, logStatus == 2?3:2,
                6, logStatus, userAccount, "NULL", date, -1);
        return null;
    }

    @Override
    public List<Log> cancelRecord(String userAccount, Integer logId, Integer logStatus) throws Exception {
        if (logStatus == 4){
            throw new Exception("This log has been canceled");
        }
        logsCancelRecord.cancelRecord(logId);
        return null;
    }


}
