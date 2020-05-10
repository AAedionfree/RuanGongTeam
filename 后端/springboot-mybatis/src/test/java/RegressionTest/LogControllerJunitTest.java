package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.DeviceController;
import org.spring.springboot.controller.LogController;
import org.spring.springboot.controller.UserController;
import org.spring.springboot.dao.devices.DevWorkStatusDao;
import org.spring.springboot.domain.Device;
import org.spring.springboot.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.JVM)
public class LogControllerJunitTest {
    @Autowired
    LogController logController;

    @Autowired
    DevWorkStatusDao devWorkStatusDao;

    @Autowired
    DeviceController deviceController;

    @BeforeClass
    public static void setTestInfo() {
        RegressionTest.setTestInfo("---test.LogControllerJunitTest---:");
    }

    @Before
    public void testBefore() {
        System.out.println("LogController Test Start:");
    }

    @Test
    public void findAllLogs() {
        ResultBean<Log> logs = logController.findAllLogs();
        assertEquals(0, logs.getCode());
    }

    @Test
    public void findLogsByUserId() {
        ResultBean<Log> logs = logController.findLogsByUserAccount("-1");
        assertEquals(0, logs.getCode());
        assertEquals(1, logs.getData().size());
    }

    @Test
    public void addFixLog() {
        ResultBean addFixLogAuthError = logController.addFixLog("AAedion", -1);
        assertEquals(-1, addFixLogAuthError.getCode());
        assertEquals(null, addFixLogAuthError.getData());
        assertEquals("Authentication failed AAedion", addFixLogAuthError.getMessage());

        ResultBean addFixDamageWorkStatusError = logController.addDamageLog("TestUserAccount", -1);
        assertEquals(-1, addFixDamageWorkStatusError.getCode());
        assertEquals(null, addFixDamageWorkStatusError.getData());
        assertEquals("Can't deal device with devStatus:3", addFixDamageWorkStatusError.getMessage());

        ResultBean addFixLog = logController.addFixLog("TestUserAccount", -1);
        assertEquals(0, addFixLog.getCode());
        assertEquals(null, addFixLog.getData());
        assertEquals("success", addFixLog.getMessage());
    }

    @Test
    public void addDamageLog() {
        ResultBean addDamageLogAuthError = logController.addDamageLog("AAedion", -1);
        assertEquals(-1, addDamageLogAuthError.getCode());
        assertEquals(null, addDamageLogAuthError.getData());
        assertEquals("Authentication failed AAedion", addDamageLogAuthError.getMessage());

        ResultBean addFixLogWorkStatusError = logController.addFixLog("TestUserAccount", -1);
        assertEquals(-1, addFixLogWorkStatusError.getCode());
        assertEquals(null, addFixLogWorkStatusError.getData());
        assertEquals("Can't deal device with devStatus:1", addFixLogWorkStatusError.getMessage());

        ResultBean addDamageLog = logController.addDamageLog("TestUserAccount", -1);
        assertEquals(0, addDamageLog.getCode());
        assertEquals(null, addDamageLog.getData());
        assertEquals("success", addDamageLog.getMessage());
    }

    @Test
    public void addScrapRecord() {
        ResultBean addScrapLogAuthError = logController.addScrapLog("AAedion", -1);
        assertEquals(-1, addScrapLogAuthError.getCode());
        assertEquals(null, addScrapLogAuthError.getData(), null);
        assertEquals("Authentication failed AAedion", addScrapLogAuthError.getMessage());

        ResultBean addScrapLog = logController.addScrapLog("TestUserAccount", -1);
        assertEquals(0, addScrapLog.getCode());
        assertEquals(null, addScrapLog.getData());
        assertEquals("success", addScrapLog.getMessage());

        ResultBean scrapLog = logController.findScrapLog("TestUserAccount");
        assertEquals(0, scrapLog.getCode());
        assertEquals("success", scrapLog.getMessage());
        assertEquals(1, scrapLog.getData().size());
        int logId = new ArrayList<Log>(scrapLog.getData()).get(0).getLogId();


        ResultBean dealScrapLog = logController.dealScrapLog("TestUserAccount", logId, 1);
        assertEquals(0, dealScrapLog.getCode());
        assertEquals(null, dealScrapLog.getData());
        assertEquals("success", dealScrapLog.getMessage());

        devWorkStatusDao.updateDevWorkStatusByDevId(-1, 3);

        addScrapLog = logController.addScrapLog("TestUserAccount", -1);
        assertEquals(0, addScrapLog.getCode());
        assertEquals(null, addScrapLog.getData());
        assertEquals("success", addScrapLog.getMessage());
    }

    @Test
    public void findScrapRecord(){
        ResultBean scrapLog = logController.findScrapLog("TestUserAccount");
        assertEquals(0, scrapLog.getCode());
        assertEquals("success", scrapLog.getMessage());
        assertEquals(1, scrapLog.getData().size());
    }

    @Test
    public void dealScrapRecord(){
        ResultBean scrapLog = logController.findScrapLog("TestUserAccount");
        int logId = new ArrayList<Log>(scrapLog.getData()).get(0).getLogId();

        ResultBean dealScrapLog = logController.dealScrapLog("TestUserAccount", logId, 0);
        assertEquals(0, dealScrapLog.getCode());
        assertEquals(null, dealScrapLog.getData());
        assertEquals("success", dealScrapLog.getMessage());

        ResultBean<Device> device = deviceController.findDeviceByDevId(-1);
        Device dev = new ArrayList<Device>(device.getData()).get(0);
        assertEquals(0, device.getCode());
        assertEquals(3, dev.getDevWorkStatus());
    }

    @After
    public void testAfter() {
        System.out.println("LogController Test End:");
    }
}
