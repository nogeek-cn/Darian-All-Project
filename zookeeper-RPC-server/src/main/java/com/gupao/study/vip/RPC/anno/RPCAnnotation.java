package com.gupao.study.vip.RPC.anno;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定一注解
 * <br>作者：Darian
 **/
@Target(ElementType.TYPE)   // 设置这个注解的作用范围
@Retention(RetentionPolicy.RUNTIME)  // 设置这个注解的生命周期,
                    // RetentionPolicy.RUNTIME 运行的生命周期
public @interface RPCAnnotation {

    /*
     * 对外发布服务的地址
     */
    Class<?> value();
}
