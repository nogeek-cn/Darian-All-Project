package RPC;

import java.lang.reflect.Proxy;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class RpcclientProxy {

    // 这个里边要去做一个代理，

    public <T> T clientProxy(final Class interfaceCls,
                             final String host, final  int port){
        return (T)Proxy.newProxyInstance(
                interfaceCls.getClassLoader(),
                new Class[] {interfaceCls},
                new RemoteInvocationHandler(host,port));
    }
}