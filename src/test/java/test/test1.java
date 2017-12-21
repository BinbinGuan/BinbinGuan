package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONToken;
import com.idcos.Application;
import com.idcos.cloud.core.common.util.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.method.P;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author GuanBin
 * @version test1.java, v1 2017/9/20 下午12:39 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class test1 {

    @Test
    public void test() {
        test5();
    }

    private void testMap() {
        //TreeMap是按健默认排序的
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        map.put("b", 8);
        map.put("a", 3);
        map.put("m", 5);

        System.out.println(map);
    }

    private void test1() {
        String[] a = { "1", "2", "3" };
        Set<String> s = new TreeSet<>();
        List<String> b = new ArrayList<>();
        Collections.addAll(b, a);
        System.out.println(b);
    }

    //测试打印格式化的json字符串
    private void test2() {
        JSONObject item = new JSONObject();
        item.put("name", "管彬彬");
        item.put("age", "男");
        System.out.println(JSONObject.toJSONString(item, true));
    }

    //测试截取字符串
    private void test3() {
        String str = "0.1";
        //若str中不包含“.”则返回-1；若包含则返回该字符的起始索引
        int a = str.indexOf(".");
        //截取起始为0，终点为“.”的索引的起始位置
        String b = str.substring(0, str.indexOf("."));
        System.out.println(b);
        String c = "asdfasdkfaks";

        System.out.format(c);

    }

    //    diskPrice = Double.parseDouble(resPriceDiskDo.getPrice());

    private void test4() {
        double a = Double.parseDouble("0.5");
        System.out.println(a);
    }

    private void test5() {

        System.out.println(System.currentTimeMillis() / 1000L);
        System.out.println(System.currentTimeMillis() / 1000L + 18000);

        String a="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYXZpbmNpIiwidXNlcklkIjoiODU4YmU0NmUtYWY4Yy00NmQ5LTkxNzUtZDU1ZmI1ZGM5NGZiIiwibmFtZSI6ImRhdmluY2kiLCJsb2dpbklkIjoiZGF2aW5jaSIsImxvZ2luTmFtZSI6ImRhdmluY2kiLCJ0ZW5hbnRJZCI6ImRlZmF1bHQiLCJ0aW1lb3V0IjoyMTYwMCwiZXhwIjoyNTE2Njg0NDAwLCJjcmVhdFRpbWUiOjE1MTM1ODM0NDY5NTksInRlbmFudE5hbWUiOiLnrqHnkIbnp5_miLcifQ.EA-xcouxg4lTbSOvw9-txSWKvvgsnDujylVlyLiODwY";
        Claims claims = (Claims) Jwts.parser().setSigningKey("QzQzNjAxMDQtNEJGMC00Q0IyLUEyOTQtOEM2Mzk2RDZGRDk2")
            .parseClaimsJws(a).getBody();
        System.out.println(claims);

    }

    private void test19() {

    }

    private void test6() {
        //object如果实际是Map类型则可以转化成功为map
        Map<String, String> map = new HashMap<>();
        map.put("dept", "测试");
        map.put("ceshi", "12");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("1", map);
        Map<String, String> map2 = (Map<String, String>) map1.get("1");
        System.out.println(map2.get("dept").toString());
    }

    private void test99() {
        Date date = DateUtil.strToSimpleFormat("2049-10-01 15:00");
        System.out.println(date.getTime() / 1000L);
    }

    private void test7() {
        int a = 1;
        String b = null;
        if (a == 2 && b.equals("a")) {
            System.out.println("chu");
        } else {
            System.out.println("测试&&是否第一个不成立，就不会走第二个");
        }
    }

    private void convertTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        System.out.println(format.format(now));

        //减去一个月
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        Date date = calendar.getTime();
        System.out.println(format.format(date));

    }

    private void testInt() {
        double a = 0.00;
        double b = 1.88;
        int c = (int) (a);
        int d = (int) (b);

        System.out.println(c);
        System.out.println(d);
    }

    private void testSpilt() {

        String name = "部门1>部门2>部门3";
        String p = name.split(">")[0];
        String m = name.split(">")[1];
        String n = name.split(">")[2];

        String[] array = name.split(">");

        System.out.println(p);
        System.out.println(m);
        System.out.println(n);

        System.out.println("输出最后一位" + array[array.length - 1]);

    }

    private void test15() {
        String ids = "4aadfaljf.asdfasfd.asdfasdfas";
        String[] idArray = ids.split("\\.");
        for (int i = idArray.length - 2; i >= 0; i--) {
            System.out.println("测试" + idArray[i]);
        }

        for (int i = 0; i < idArray.length; i++) {
            System.out.println("测试2" + idArray[i]);

        }

    }

    private void test16() {
        String a = "{\\\"content\\\":{\\\"managerId\\\":\\\"guoyiping\\\",\\\"managerName\\\":\\\"郭一平\\\",\\\"projectId\\\":\\\"eb2d5bc1-64fb-452d-84a2-17669103f474\\\",\\\"title\\\":\\\"测试广发申请\\\",\\\"remark\\\":\\\"测试\\\",\\\"usage\\\":\\\"测试\\\",\\\"owner\\\":\\\"daixizhao\\\",\\\"content\\\":[{\\\"resPoolId\\\":\\\"785563b4-27b4-460d-84dc-d20496c0a7db\\\",\\\"os\\\":\\\"fbff8c6c-4ce3-11e7-8927-005056a95006\\\",\\\"spec\\\":\\\"b12fbbe8-b508-4cb0-9666-8e09a0643ad3\\\",\\\"ipInfo\\\":\\\"192.168.163.103\\\",\\\"expire\\\":\\\"3\\\",\\\"num\\\":\\\"1\\\",\\\"tag\\\":\\\"oracle\\\"}],\\\"__trackId\\\":\\\"1711071019021437\\\",\\\"applyTime\\\":\\\"2017-11-07 10:20:58\\\",\\\"srvInputParamsFull\\\":\\\"{\\\\\\\"detail\\\\\\\":[{\\\\\\\"label\\\\\\\":\\\\\\\"业务负责人\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"代希召\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"daixizhao\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"运维负责人\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"郭一平\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"guoyiping\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"申请人\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"代希召\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"daixizhao\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"申请标题\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"测试广发申请\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"项目\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"eb2d5bc1-64fb-452d-84a2-17669103f474\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"XMDB开发测试\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"用途\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"测>试\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"申请内容\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"测试\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"主机信息\\\\\\\",\\\\\\\"value\\\\\\\":[{\\\\\\\"label\\\\\\\":\\\\\\\"第1批次\\\\\\\",\\\\\\\"value\\\\\\\":[{\\\\\\\"label\\\\\\\":\\\\\\\"资源>池\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"785563b4-27b4-460d-84dc-d20496c0a7db\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"杭州-OpenStack-v3\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"操作系统\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"fbff8c6c-4ce3-11e7-8927-005056a95006\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Redhat6.7\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"规格\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"b12fbbe8-b508-4cb0-9666-8e09a0643ad3\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"1C1G100G\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"IP\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"192.168.163.103\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"使用期限(月)\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"3\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"数量(台)\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"1\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"分类\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"oracle\\\\\\\"}}]}]},{\\\\\\\"label\\\\\\\":\\\\\\\"OA审批页面\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"<a target=\\\\\\\\\\\\\\\"_blank\\\\\\\\\\\\\\\" href=\\\\\\\\\\\\\\\"http://flow.gf.com.cn/bpm/workbench?service=RES-001\\\\\\\\\\\\\\\">点击打开OA审批页面</a>\\\\\\\"}}],\\\\\\\"list\\\\\\\":[{\\\\\\\"label\\\\\\\":\\\\\\\"业务负责人\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"代希召\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"daixizhao\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"申请人\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"代希召\\\\\\\",\\\\\\\"id\\\\\\\":\\\\\\\"daixizhao\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"申请标题\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"测试广发申请\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"项目\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"eb2d5bc1-64fb-452d-84a2-17669103f474\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"XMDB开发测试\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"用途\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"测试\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"申请内容\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"测试\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"资源池\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"785563b4-27b4-460d-84dc-d20496c0a7db\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"杭州-OpenStack-v3\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"操作系统\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"fbff8c6c-4ce3-11e7-8927-005056a95006\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Redhat6.7\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"规格\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"id\\\\\\\":\\\\\\\"b12fbbe8-b508-4cb0-9666-8e09a0643ad3\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"1C1G100G\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"IP\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"192.168.163.103\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"使用期限(月)\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"3\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"数量(台)\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"1\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"分类\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"oracle\\\\\\\"}},{\\\\\\\"label\\\\\\\":\\\\\\\"OA审批页面\\\\\\\",\\\\\\\"value\\\\\\\":{\\\\\\\"name\\\\\\\":\\\\\\\"<a target=\\\\\\\\\\\\\\\"_blank\\\\\\\\\\\\\\\" href=\\\\\\\\\\\\\\\"http://flow.gf.com.cn/bpm/workbench?service=RES-001\\\\\\\\\\\\\\\">点击打开OA审批页面</a>\\\\\\\"}}]}\\\",\\\"tenantId\\\":\\\"default\\\"}}";
        JSONObject item = JSONObject.parseObject(a);
        System.out.println(item.toJSONString());

    }

    private void testList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list.toString());

        //        result |= c.add(element);
    }

    private void testSet() {
        List<String> stringList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        stringList.addAll(strings);

        System.out.println(stringList.size());

    }

    private void testChart() {
        String str = "abcdefg";
        char a = str.charAt(0);
        System.out.println(a);
        //测试isDigit()方法
        boolean t1 = Character.isDigit(a);
        boolean t2 = Character.isDigit('3');
        System.out.println(t1);
        System.out.println(t2);

    }

}
