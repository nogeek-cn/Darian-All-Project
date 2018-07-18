package com.gupao.edu.study.vip;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class Client_demo {
    public static void main(String[] args) throws IOException {
        /*
        虽然我们客户端依赖 dubbo， 服务端也依赖 dubbo ,
        我们通信间的地址 dubbo://192.168.136.1:20880/com.gupao.edu.study.vip.IGpHello
        没有了，
        我们客户端不知道服务端发布出去的地址。
        所以我们需要在dubbo:reference中配置我们的 URL
         */

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dubbo-client.xml");

        // xml 中配置的 bean，强制转化成 IGPHello ，本来就是一个接口
        // 得到 IGPHello 的远程代理对象
        IGpHello iGpHello = (IGpHello) context.getBean("gpHelloService");

        for (int i = 0; i < 10; i++) {
            System.out.println(iGpHello.sayHello("darian"));
        }

        System.in.read();
    }
}
