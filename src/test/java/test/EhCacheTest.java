package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.idcos.Application;
import com.idcos.gaunbin.dal.auto.dao.guan.DcosLogDAO;
import com.idcos.gaunbin.dal.auto.dataobject.guan.DcosLogDO;

/**
 * @author GuanBin
 * @version EhCacheTest.java, v1 2018/4/25 下午4:11 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class EhCacheTest {

    @Autowired
    private  DcosLogDAO dcosLogDAO;

    @Before
    public void setDo() {
        DcosLogDO dcosLogDO = new DcosLogDO();
        dcosLogDO.setMethodName("测试");
        dcosLogDO.setTime("123");
        dcosLogDAO.save(dcosLogDO);
    }

    @Test
    public void testCache() {

        dcosLogDAO.findByMethodName("测试");
        System.out.println("第一次测试");
        dcosLogDAO.findByMethodName("测试");
        System.out.println("第二次测试");

    }

    public static void main(String[] args){
    }


    }
