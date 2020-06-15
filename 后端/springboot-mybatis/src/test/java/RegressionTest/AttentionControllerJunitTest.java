package RegressionTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.RegressionTest;
import org.spring.springboot.ResultBean;
import org.spring.springboot.controller.AttentionController;
import org.spring.springboot.domain.AttentionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttentionControllerJunitTest {
    @Autowired
    AttentionController attentionController;

    @BeforeClass
    public static void setTestInfo() {
        RegressionTest.setTestInfo("---test.AttentionControllerJunitTest---:");
    }

    @Before
    public void testBefore() {
        System.out.println("AttentionController Test Start:");
    }

    @Test
    public void test001_addAttentionRecord() {
        ResultBean<AttentionItem> addAttention = attentionController
                .addAttentionRecord("TestUserAccount", -1);
        assertEquals(0, addAttention.getCode());
    }

    @Test
    public void test002_FindAttentionRecord() {
        ResultBean<AttentionItem> findAttention = attentionController
                .FindAttentionRecord("TestUserAccount");
        assertEquals(0, findAttention.getCode());
        ArrayList<AttentionItem> attentionList = new ArrayList<>(findAttention.getData());
        assertEquals(-1, attentionList.get(0).getDevId());
        assertEquals("TestUserAccount", attentionList.get(0).getUserAccount());
    }

    @Test
    public void test003_cancelAttentionRecord() {
        ResultBean<AttentionItem> cancelAttention = attentionController
                .cancelAttentionRecord("TestUserAccount",-1);
        assertEquals(0, cancelAttention.getCode());

        ResultBean<AttentionItem> findAttention = attentionController
                .FindAttentionRecord("TestUserAccount");
        assertEquals(0, findAttention.getCode());
        ArrayList<AttentionItem> attentionList = new ArrayList<>(findAttention.getData());
        assertEquals(0, attentionList.size());
    }

    @After
    public void testAfter() {
        System.out.println("AttentionController Test End:");
    }
}
