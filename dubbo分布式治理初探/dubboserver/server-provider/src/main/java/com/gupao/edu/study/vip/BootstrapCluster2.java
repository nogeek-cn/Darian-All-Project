package com.gupao.edu.study.vip;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class BootstrapCluster2 {

    public static void main(String[] args) throws IOException {
        // 去加载对应的 xml 文件，去 load
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/dubbo-cluster2.xml");

        // 启动
        context.start();

        // 阻塞当前的进程
        System.in.read();
    }
}
