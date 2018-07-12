package com.gupao.study.vip.RPC.zk;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public interface IServiceDiscovery {

    /**
     * 根据请求的服务地址，获得相应的调用地址
     **/
    String discover(String serviceName);
}
