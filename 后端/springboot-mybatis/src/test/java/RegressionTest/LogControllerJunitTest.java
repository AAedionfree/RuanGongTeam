package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.LogController;
import org.spring.springboot.controller.UserController;
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

    @BeforeClass
    public static void setTestInfo(){
        RegressionTest.setTestInfo("---test.LogControllerJunitTest---:");
    }
    @Before
    public void testBefore() {
        System.out.println("LogController Test Start:");
    }

    @Test
    public void findAllLogs(){
        ResultBean<Log> logs = logController.findAllLogs();
        assertEquals(logs.getCode(), 0);
    }

    @Test
    public void findLogsByUserId(){
        ResultBean<Log> logs = logController.findLogsByUserAccount("-1");
        assertEquals(logs.getCode(), 0);
        assertEquals(logs.getData().size(), 1);
    }

    @Test
    public void addFixLog(){
        ResultBean addFixLogAuthError = logController.addFixLog("AAedion",-1);
        assertEquals(addFixLogAuthError.getCode(), -1);
        assertEquals(addFixLogAuthError.getData(), null);
        assertEquals(addFixLogAuthError.getMessage(),"Authentication failed AAedion");

        ResultBean addFixDamageWorkStatusError = logController.addDamageLog("TestUserAccount",-1);
        assertEquals(addFixDamageWorkStatusError.getCode(), -1);
        assertEquals(addFixDamageWorkStatusError.getData(), null);
        assertEquals(addFixDamageWorkStatusError.getMessage(),"Can't deal device with devStatus:3");

        ResultBean addFixLog = logController.addFixLog("TestUserAccount",-1);
        assertEquals(addFixLog.getCode(), 0);
        assertEquals(addFixLog.getData(), null);
        assertEquals(addFixLog.getMessage(),"success");
    }

    @Test
    public void addDamageLog(){
        ResultBean addDamageLogAuthError = logController.addDamageLog("AAedion",-1);
        assertEquals(addDamageLogAuthError.getCode(), -1);
        assertEquals(addDamageLogAuthError.getData(), null);
        assertEquals(addDamageLogAuthError.getMessage(),"Authentication failed AAedion");

        ResultBean addFixLogWorkStatusError = logController.addFixLog("TestUserAccount",-1);
        assertEquals(addFixLogWorkStatusError.getCode(), -1);
        assertEquals(addFixLogWorkStatusError.getData(), null);
        assertEquals(addFixLogWorkStatusError.getMessage(),"Can't deal device with devStatus:1");

        ResultBean addDamageLog = logController.addDamageLog("TestUserAccount",-1);
        assertEquals(addDamageLog.getCode(), 0);
        assertEquals(addDamageLog.getData(), null);
        assertEquals(addDamageLog.getMessage(),"success");
    }

    @Test
    public void addScrapRecord(){
        ResultBean addScrapLogAuthError = logController.addScrapLog("AAedion",-1);
        assertEquals(addScrapLogAuthError.getCode(), -1);
        assertEquals(addScrapLogAuthError.getData(), null);
        assertEquals(addScrapLogAuthError.getMessage(),"Authentication failed AAedion");

        ResultBean addScrapLog = logController.addScrapLog("TestUserAccount",-1);
        assertEquals(addScrapLog.getCode(), 0);
        assertEquals(addScrapLog.getData(), null);
        assertEquals(addScrapLog.getMessage(),"success");

        ResultBean scrapLog = logController.findScrapLog("TestUserAccount");
        assertEquals(scrapLog.getCode(), 0);
        assertEquals(scrapLog.getMessage(),"success");
        assertEquals(scrapLog.getData().size(), 1);
        int logId = new ArrayList<Log>(scrapLog.getData()).get(0).getLogId();

        ResultBean dealScrapLog = logController.dealScrapLog("TestUserAccount",logId,1);
        assertEquals(dealScrapLog.getCode(), 0);
        assertEquals(dealScrapLog.getData(), null);
        assertEquals(dealScrapLog.getMessage(),"success");
    }

    @After
    public void testAfter() {
        System.out.println("LogController Test End:");
    }
}
