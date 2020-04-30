import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.DeviceController;
import org.spring.springboot.controller.UserController;
import org.spring.springboot.domain.Device;
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
public class DeviceControllerJunitTest {


    @Autowired
    DeviceController deviceController;

    @Before
    public void testBefore(){
        System.out.println("DeviceController Test Start:");
    }

    @Test
    public void test() {
        // find devInfo by devId
        ResultBean<Device> findDeviceByDeviceId = deviceController.findDeviceByDevId("1");
        assertEquals(-1, findDeviceByDeviceId.getCode());
        assertEquals("not found DeviceID", findDeviceByDeviceId.getMessage());
        assertTrue(findDeviceByDeviceId.getData() == null);


        // find devInfo by ManagerId
        /*
        ResultBean<Device> findDeviceByManagerId = deviceController.findDeviceByManagerId(1);
        assertEquals(-1, findDeviceByManagerId.getCode());
        assertEquals("MangerId not Exist in DataBase", findDeviceByManagerId.getMessage());
        assertTrue(findDeviceByManagerId.getData() == null);
        */

        // find devInfo by userAuth
        /*
        ResultBean<Device> findDeviceByDevAuth = deviceController.findDeviceByDevAuth(3);
        assertEquals(-1, findDeviceByDevAuth.getCode());
        assertEquals("DevAuth not Exist in DataBase", findDeviceByDevAuth.getMessage());
        assertTrue(findDeviceByDevAuth.getData() == null);
        */

        // find devInfo by userAccount
        ResultBean<Device> findDeviceByUserAccount = deviceController.findDeviceByUserAccount("22233");
        assertEquals(-1, findDeviceByUserAccount.getCode());
        assertEquals("userAccount not exist in DataBase", findDeviceByUserAccount.getMessage());
        assertTrue(findDeviceByUserAccount.getData() == null);

    }

    @After
    public void testAfter(){
        System.out.println("DeviceController Test End:");
    }
}