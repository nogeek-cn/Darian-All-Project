package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.zk.IServiceDiscovery;

import java.lang.reflect.Proxy;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class RpcclientProxy {

    private IServiceDiscovery iServiceDiscovery;

    public RpcclientProxy(IServiceDiscovery iServiceDiscovery) {
        this.iServiceDiscovery = iServiceDiscovery;
    }

    public <T> T clientProxy(final Class interfaceCls
                           ){

        System.out.println(interfaceCls);
        System.out.println(interfaceCls.getClassLoader());

        return (T)Proxy.newProxyInstance(
                interfaceCls.getClassLoader(),
                new Class[] {interfaceCls},
                new RemoteInvocationHandler(iServiceDiscovery));
    }
}