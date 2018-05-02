package test.annotation.util;

import test.annotation.FruitColor;
import test.annotation.FruitName;
import test.annotation.FruitProvider;

import java.lang.reflect.Field;

/**
 * @author GuanBin
 * @version AnnotationUtil.java, v1 2018/4/23 下午11:54 GuanBin Exp $$
 */
public class AnnotationUtil {
    public static void getFruitInfo(Class<?> clazz) {

        //获取一个类中的属性（明天学习获取所有类中加的注解）
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName annotation = field.getAnnotation(FruitName.class);
                System.out.println("水果名称" + annotation.value() + "\n");
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor annotation = field.getAnnotation(FruitColor.class);
                System.out.println(annotation.fruitColor().toString() + "\n");
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider annotation = field.getAnnotation(FruitProvider.class);
                System.out
                    .println("供货商id是" + annotation.id() + " 名称是" + annotation.name() + "地址是：" + annotation.address());
            }
        }

    }
}
