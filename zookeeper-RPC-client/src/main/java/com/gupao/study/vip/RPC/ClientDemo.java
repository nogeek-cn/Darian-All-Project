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
                ServiceDiscoveryImpl(zkConfig.ZK_REGISTER_PATH);

        RpcclientProxy rpcclientProxy = new RpcclientProxy(iServiceDiscovery);

        IGPHello IGPHello = rpcclientProxy.clientProxy
                (IGPHello.class);

        System.out.println(IGPHello);

        System.out.println(IGPHello.sayHello("Darian"));
    }
}
