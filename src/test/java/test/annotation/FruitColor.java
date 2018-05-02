package test.annotation;

import java.lang.annotation.*;

/**
 * @author GuanBin
 * @version FruitColor.java, v1 2018/4/23 下午11:40 GuanBin Exp $$
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color {BULE,RED,GREEN};

    //默认值是GREEN
    Color fruitColor() default Color.GREEN;


}


