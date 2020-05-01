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
        ResultBean<Log> logs = logController.findLogsByUserId(-1);
        assertEquals(logs.getCode(), 0);
        assertEquals(logs.getData().size(), 1);
    }

    @After
    public void testAfter() {
        System.out.println("LogController Test End:");
    }
}
