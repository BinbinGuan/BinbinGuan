package test;

import com.idcos.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GuanBin
 * @version JavaSpecification.java, v1 2017/11/30 下午2:40 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class JavaSpecification {
    @Test
    public void test() {
        testListToArray();
        testasList();
    }

    @SuppressWarnings("unchecked")
    private void testListToArray() {
        List<String> list = new ArrayList<String>(2);
        List<String> m=new ArrayList<>();
        list.add("guan");
        list.add("binbin");
        boolean a = list.contains(new String("guan"));
        System.out.println(a);

        String[] array = new String[list.size()];
        array = list.toArray(array);
        for (String str : array) {
            System.out.println("*****" + str);

        }
    }

    @SuppressWarnings("unchecked") // 是在编译时不要抛出编译是的警告信息
    @Deprecated //意思是此方法将不再更新，其他版本中用新的方法可以替换此方法
    private void testasList() {
        String[] str = new String[] { "guan", "bin" };
        List<String> list = Arrays.asList(str); // 转化后，底层还是一个数组，故不能使用list中的add/remove/clear 等方法
        //        list.add("test");
        str[0] = "hao";
        for (String st : list) {
            System.out.println(st);
        }
    }

}
