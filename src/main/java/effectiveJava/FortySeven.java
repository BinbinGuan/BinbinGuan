package effectiveJava;

import org.thymeleaf.util.ListUtils;

import java.util.*;

/**
 * @author GuanBin
 * @version FortySeven.java, v1 2017/11/22 上午12:34 GuanBin Exp $$
 */
public class FortySeven {
    //使用标准类库
    private static final Random random = new Random();

    //测试随机数
    public static void main(String[] args) {

        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random.nextInt(n) < n / 2) {
               low++;
            }
        }
        System.out.println(low);

    }


}
