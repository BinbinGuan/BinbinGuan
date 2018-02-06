package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.idcos.Application;

import item.Complex;

/**
 * @author GuanBin
 * @version testasd.java, v1 2017/11/18 下午2:26 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class testasd {
    @Test
    public void test(){

        Complex complex=new Complex(0.4,9);
        Complex complex1= complex.add(complex);//操作后返回一个新的对象，而不是修改之前的对象
        System.out.println(complex.getRe()+"-------"+complex.getIm());
        System.out.println(complex1.getRe()+"-------"+complex1.getIm());

    }
}
