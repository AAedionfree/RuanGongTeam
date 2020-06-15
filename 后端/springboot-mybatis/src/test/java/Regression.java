import RegressionTest.AttentionControllerJunitTest;
import RegressionTest.LogControllerJunitTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.spring.springboot.Application;
import org.spring.springboot.HttpClient;
import org.springframework.boot.test.context.SpringBootTest;
import RegressionTest.DeviceControllerJunitTest;
import RegressionTest.UserControllerJunitTest;

@SpringBootTest(classes = Application.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({UserControllerJunitTest.class,
        DeviceControllerJunitTest.class,
        LogControllerJunitTest.class,
        AttentionControllerJunitTest.class})

public class Regression {
    @BeforeClass
    public static void before() throws Exception {
        HttpClient.record("------------------RegressionTest Start!!!------------------:");
        org.spring.springboot.RegressionTest.RegressionTestBegin();
    }

    @AfterClass
    public static void after() throws Exception {
        org.spring.springboot.RegressionTest.RegressionTestEnd();
        HttpClient.record("------------------RegressionTest End!!!------------------:");
    }
}
