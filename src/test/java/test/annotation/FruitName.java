package test.annotation;

import java.lang.annotation.*;

/**
 * @author GuanBin
 * @version FruitName.java, v1 2018/4/23 下午11:34 GuanBin Exp $$
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

    //若注解属性是单个，默认命名为value，“”和-1都代表没有值
    String value() default "";
}
