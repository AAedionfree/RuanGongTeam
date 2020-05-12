package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.DeviceController;
import org.spring.springboot.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DeviceControllerJunitTest {


    @Autowired
    DeviceController deviceController;

    @BeforeClass
    public static void setTestInfo() {
        RegressionTest.setTestInfo("---test.DeviceControllerJunitTest---:");
    }

    @Before
    public void testBefore() {
        System.out.println("DeviceController Test Start:");
    }

    @Test
    public void findDeviceByDevId() {
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
                && device.get(0).getChargeAccount().equals("TestChargeAccount")
                && device.get(0).getManagerAccount().equals("TestManagerAccount")
                && device.get(0).getDevWorkStatus() == 3
                && device.get(0).getDevStatus() == 0
                && device.get(0).getDevAuth() == 0);
    }

    @Test
    public void findDeviceByManagerAccount() {
        ResultBean<Device> findDeviceByManagerAccount = deviceController.findDeviceByManagerAccount("TestManagerAccount");
        assertEquals(0, findDeviceByManagerAccount.getCode());
        assertEquals("success", findDeviceByManagerAccount.getMessage());
        assertNotNull(findDeviceByManagerAccount.getData());
    }

    @Test
    public void findDeviceByDevAuth() {
        ResultBean<Device> findDeviceByDevAuth = deviceController.findDeviceByDevAuth(0);
        assertEquals(0, findDeviceByDevAuth.getCode());
        assertEquals("success", findDeviceByDevAuth.getMessage());
        assertNotNull(findDeviceByDevAuth.getData());
    }

    @Test
    public void findDeviceByUserAccount() {
        ResultBean<Device> findDeviceByUserAccount = deviceController.findDeviceByUserAccount("22233");
        assertEquals(-1, findDeviceByUserAccount.getCode());
        assertEquals("userAccount not exist in DataBase", findDeviceByUserAccount.getMessage());
        assertNull(findDeviceByUserAccount.getData());
    }

    @Test
    public void lendDeviceByDevId() {
        ResultBean<Device> lendDeviceByDevId = deviceController.lendDeviceByDevId("TestUserAccount", -1);
        assertEquals(-1, lendDeviceByDevId.getCode());
        assertEquals("Device can not be lend to you", lendDeviceByDevId.getMessage());
        assertNull(lendDeviceByDevId.getData());
    }

    @Test
    public void findDeviceByDevUserAccount() {
        ResultBean<Device> findDeviceByDevUserAccount = deviceController.findDeviceByDevUserAccount("TestUserAccount");
        assertEquals(0, findDeviceByDevUserAccount.getCode());
        assertEquals("success", findDeviceByDevUserAccount.getMessage());
        assertNotNull(findDeviceByDevUserAccount.getData());
    }

    @Test
    public void revertDeviceByDevId() {
        ResultBean<Device> revertDeviceByDevId = deviceController.revertDeviceByDevId("TestUserAccount", -1);
        assertEquals(-1, revertDeviceByDevId.getCode());
        assertEquals("Device can not be reverted", revertDeviceByDevId.getMessage());
        assertNull(revertDeviceByDevId.getData());
    }

    @After
    public void testAfter() {
        System.out.println("DeviceController Test End:");
    }
}