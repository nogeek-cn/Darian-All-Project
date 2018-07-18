package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.zk.IServiceDiscovery;
import com.gupao.study.vip.RPC.zk.ServiceDiscoveryImpl;
import com.gupao.study.vip.RPC.zk.zkConfig;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class ClientDemo {

    public static void main(String[] args) {

        IServiceDiscovery iServiceDiscovery = new
                ServiceDiscoveryImpl(zkConfig.CONNECTION_STRING);

        RpcclientProxy rpcclientProxy = new RpcclientProxy(iServiceDiscovery);

        for (int i = 0; i < 10; i++) {
            IGPHello IGPHello = rpcclientProxy.clientProxy
                    (IGPHello.class, null);

            System.out.println(IGPHello.sayHello("Darian"));
            System.out.println();
        }
//        IGPHello IGPHello = rpcclientProxy.clientProxy
//                (IGPHello.class, null);
//
//
//        //System.out.println(IGPHello);
//
//        System.out.println(IGPHello.sayHello("Darian"));

//        System.out.println("=-----=版本二");
//        IGPHello igpHello2 = rpcclientProxy.clientProxy(IGPHello.class, "2.0");
//        System.out.println(igpHello2.sayHello("darian2"));
    }
}

//      控制台的输出
//    interface com.gupao.study.vip.RPC.IGPHello
//    sun.misc.Launcher$AppClassLoader@18b4aac2
//    调用的方法的名字：public abstract java.lang.String com.gupao.study.vip.RPC.IGPHello.sayHello(java.lang.String)
//    要调用的接口的名字：com.gupao.study.vip.RPC.IGPHello
//    服务在zookeeper上的地址：/registrys/com.gupao.study.vip.RPC.IGPHello
//    创建一个新的连接
//    服务的IP: 127.0.0.1:8080
//    hello, Darian
