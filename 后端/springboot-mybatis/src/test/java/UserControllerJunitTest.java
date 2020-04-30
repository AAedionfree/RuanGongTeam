import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.DeviceController;
import org.spring.springboot.controller.UserController;
import org.spring.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserControllerJunitTest {


    @Autowired
    UserController userController;

    @Before
    public void testBefore(){
        System.out.println("UserController Test Start:");
    }

    @Test
    public void test() {
        // login
        ResultBean<User> login = userController.login("17182626", "666666");
        assertEquals(0, login.getCode());
        assertEquals("success", login.getMessage());
        login = userController.login("123133", "AAedion");
        assertEquals(-1, login.getCode());
        assertEquals("UserAccount not Exist in DataBase", login.getMessage());

        // findUserByUserAccount
        ResultBean<User> findUserByUserAccount = userController.findUserByUserAccount("sadaldkj");
        assertEquals(-1, findUserByUserAccount.getCode());
        assertEquals("UserAccount not Exist in DataBase", findUserByUserAccount.getMessage());
        assertTrue(findUserByUserAccount.getData() == null);


    }

    @After
    public void testAfter(){
        System.out.println("UserController Test End:");
    }
}
