package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.EmailController;
import org.spring.springboot.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailControllerJunitTest {
    @Autowired
    EmailController emailController;

    @BeforeClass
    public static void setTestInfo() {
        RegressionTest.setTestInfo("---test.EmailControllerJunitTest---:");
    }

    @Before
    public void TestBefore() {
        System.out.println("EmailController Test Start:");
    }

    @Test
    public void Test001_FindAttentionRecord(){
        ResultBean emails = emailController.findEmailByUserAccount("TestUserAccount");
        assertEquals(0, emails.getCode());
        assertEquals(0, emails.getData().size());

        ResultBean bindEmail = emailController.bindEmail("TestUserAccount",
                "TestUserPassword", "AAedion@buaa.edu.cn");
        assertEquals(0, bindEmail.getCode());

        emails = emailController.findEmailByUserAccount("TestUserAccount");
        assertEquals(0, emails.getCode());
        assertEquals(1, emails.getData().size());

    }

    @After
    public void testAfter() {
        System.out.println("EmailController Test End:");
    }
}
