package me.zhengjie.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    // 基本对象的属性名
    String propName() default "";
    // 查询方式
    Type type() default Type.EQUAL;

    /**
     * 连接查询的属性名，如User类中的dept
     */
    String joinName() default "";

    /**
     * 默认左连接
     */
    Join join() default Join.LEFT;

    enum Type {
        // jie 2019/6/4 相等
        EQUAL
        // Dong ZhaoYang 2017/8/7 中模糊查询
        , INNER_LIKE
        // 为空
        ,IS_NULL
    }

    /**
     * 适用于简单连接查询，复杂的请自定义该注解，或者使用sql查询
     */
    enum Join {
        /** jie 2019-6-4 13:18:30 */
        LEFT, RIGHT
    }

}

