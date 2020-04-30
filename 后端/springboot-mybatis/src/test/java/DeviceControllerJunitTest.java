

import org.junit.*;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.DeviceController;
import org.spring.springboot.controller.UserController;
import org.spring.springboot.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DeviceControllerJunitTest {


    @Autowired
    DeviceController deviceController;

    @BeforeClass
    public static void setTestInfo(){
        RegressionTest.setTestInfo("---DeviceControllerJunitTest---:");
    }
    @Before
    public void testBefore(){
        System.out.println("DeviceController Test Start:");
    }

    @Test
    public void test() {
        // find devInfo by devId
        ResultBean<Device> findDeviceByDeviceId = deviceController.findDeviceByDevId(-1);
        ArrayList<Device> device = new ArrayList<Device>(findDeviceByDeviceId.getData());
        assertEquals(0, findDeviceByDeviceId.getCode());
        assertEquals("success", findDeviceByDeviceId.getMessage());
        assertEquals(1, device.size());
        assertEquals(true, device.get(0).getDevName().equals("TestDevName")
                && device.get(0).getDevType().equals("TestDevType")
                && device.get(0).getDevPrise() == 0.0
                && device.get(0).getDevDate().equals("TestDevDate")
                && device.get(0).getDevPeriod().equals("TestDevPeriod")
                && device.get(0).getChargeId() == 0
                && device.get(0).getManagerId() == 0
                && device.get(0).getDevWordStatus() == 0
                && device.get(0).getDevStatus() ==0
                && device.get(0).getDevAuth() == 0);

        // find devInfo by ManagerId
        ResultBean<Device> findDeviceByManagerId = deviceController.findDeviceByManagerId(0);
        assertEquals(0, findDeviceByManagerId.getCode());
        assertEquals("success", findDeviceByManagerId.getMessage());
        assertNotNull(findDeviceByManagerId.getData());

        // find devInfo by userAuth
        ResultBean<Device> findDeviceByDevAuth = deviceController.findDeviceByDevAuth(0);
        assertEquals(0, findDeviceByDevAuth.getCode());
        assertEquals("success", findDeviceByDevAuth.getMessage());
        assertNotNull(findDeviceByDevAuth.getData());

        // find devInfo by userAccount
        ResultBean<Device> findDeviceByUserAccount = deviceController.findDeviceByUserAccount("22233");
        assertEquals(-1, findDeviceByUserAccount.getCode());
        assertEquals("userAccount not exist in DataBase", findDeviceByUserAccount.getMessage());
        assertNull(findDeviceByUserAccount.getData());

    }

    @After
    public void testAfter(){
        System.out.println("DeviceController Test End:");
    }
}