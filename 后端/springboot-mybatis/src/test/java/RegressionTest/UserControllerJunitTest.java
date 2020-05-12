package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.UserController;
import org.spring.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.JVM)
public class UserControllerJunitTest {


    @Autowired
    UserController userController;

    @BeforeClass
    public static void setTestInfo() {
        RegressionTest.setTestInfo("---test.UserControllerJunitTest---:");
    }

    @Before
    public void testBefore() {
        System.out.println("UserController Test Start:");
    }

    @Test
    public void login() {
        ResultBean<User> login = userController.login("17182626", "666666");
        assertEquals(0, login.getCode());
        assertEquals("success", login.getMessage());
        login = userController.login("123133", "AAedion");
        assertEquals(-1, login.getCode());
        assertEquals("UserAccount not Exist in DataBase", login.getMessage());
    }

    @Test
    public void findUserByUserAccount() {
        // findUserByUserAccount
        ResultBean<User> findUserByUserAccount = userController.findUserByUserAccount("sadaldkj");
        assertEquals(-1, findUserByUserAccount.getCode());
        assertEquals("UserAccount not Exist in DataBase", findUserByUserAccount.getMessage());
        assertNull(findUserByUserAccount.getData());
    }

    @Test
    public void findUserByUserId() {
        // findUserByUserId
        ResultBean findUserByUserId = userController.findUserByUserId(-1);
        ArrayList<User> user = new ArrayList<User>(findUserByUserId.getData());
        assertEquals(0, findUserByUserId.getCode());
        assertEquals("success", findUserByUserId.getMessage());
        assertEquals(1, user.size());
        assertEquals(true, user.get(0).getUserName().equals("TestUserName")
                && user.get(0).getUserAccount().equals("TestUserAccount")
                && user.get(0).getUserPassword().equals("TestUserPassword")
                && user.get(0).getUserAuthority() == 0
                && user.get(0).getUserId() == -1);
    }

    @Test
    public void userUpdatePassword() {
        ResultBean updatePassword = userController.userUpdatePassword("TestUserAccount",
                "TestUserPassword", "NewTestUserPassword");
        assertEquals(0, updatePassword.getCode());
        assertEquals(userController.login("TestUserAccount", "TestUserPassword")
                .getCode(), -1);
        assertEquals(0, userController.userUpdatePassword("TestUserAccount",
                "NewTestUserPassword", "TestUserPassword").getCode());
        assertEquals(0, userController.login("TestUserAccount", "TestUserPassword")
                .getCode());
    }

    @Test
    public void userLogout() {
        // logout
        ResultBean logout = userController.userLogout("TestUserAccount", "TestUserPassword");
        assertEquals(0, logout.getCode());
    }

    @Test
    public void userSignUp() {
        // register
        ResultBean register = userController.userSignUp(-1, "TestUserAccount", "TestUserName",
                "TestUserPassword", 0);
        assertEquals(0, register.getCode());
    }

    @After
    public void testAfter() {
        System.out.println("UserController Test End:");
    }
}
