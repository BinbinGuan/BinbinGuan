package test;

import com.idcos.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author GuanBin
 * @version Generic.java, v1 2017/12/31 下午10:34 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class Generic {

    @Test
    public void test() {
        List<String> strings = new ArrayList<String>();
//        List<Object> on = addObj(strings, new Integer(42));
        String a = strings.get(0);
    }

    private void test(Set<?> s1, Set<?> s2) {
        int result = 0;
//        s1.add(result);
        for (Object o1 : s1) {
           if(s2.contains(o1)){
               result++;
           }
        }
        System.out.println(result);
    }

}
