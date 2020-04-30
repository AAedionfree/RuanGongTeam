import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.spring.springboot.Application;
import org.spring.springboot.HttpClient;
import org.spring.springboot.RegressionTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({UserControllerJunitTest.class})
public class TestAll {
    @BeforeClass
    public static void before() throws Exception {
        HttpClient.record("------------------RegressionTest Start!!!------------------:");
        RegressionTest.RegressionTestBegin();
    }

    @AfterClass
    public static void after() throws Exception {
        RegressionTest.RegressionTestEnd();
        HttpClient.record("------------------RegressionTest End!!!------------------:");
    }
}
