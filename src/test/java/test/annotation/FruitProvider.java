package test.annotation;

import java.lang.annotation.*;

/**
 * @author GuanBin
 * @version FruitProvider.java, v1 2018/4/23 下午11:45 GuanBin Exp $$
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
     int id() default -1;

     String name() default "";

     String address() default "";

}
