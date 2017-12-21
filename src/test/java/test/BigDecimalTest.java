package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.idcos.Application;

import java.math.BigDecimal;

/**
 * @author GuanBin
 * @version BigDecimal.java, v1 2017/12/14 上午11:09 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class BigDecimalTest {

    @Test
    public void test(){
        BigDecimal a=new BigDecimal("1.23");
        BigDecimal b=new BigDecimal("1.98");
        BigDecimal c=new BigDecimal("1.99");
        BigDecimal total= a.add(b).add(c);
        System.out.println(total.toString());
        System.out.println(total.doubleValue());
    }



}
