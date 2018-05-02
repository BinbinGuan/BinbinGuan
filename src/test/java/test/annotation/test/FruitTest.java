package test.annotation.test;

import com.idcos.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.annotation.Fruit;
import test.annotation.util.AnnotationUtil;

/**
 * @author GuanBin
 * @version FruitTest.java, v1 2018/4/24 上午12:10 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class FruitTest {

    public static void main(String[] args) {
        AnnotationUtil.getFruitInfo(Fruit.class);
    }
}
