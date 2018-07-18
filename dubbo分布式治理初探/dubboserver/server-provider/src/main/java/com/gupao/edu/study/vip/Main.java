package com.gupao.edu.study.vip;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class Main {

    public static void main(String[] args) {

        // 默认情况下，会使用Spring容器来启动服务
        com.alibaba.dubbo.container.Main.main(new String[]{"spring","log4j","jetty"});
    }
}
