package com.gupao.study.vip.RPC.zk;

/**
 * <br>类说明 : 注册中心
 * <br>属性说明：
 * <br>作者：Darian
 **/
public interface IregisterCenter {

    /**
     * 注册服务名称和服务地址
     **/
    void register(String serviceName, String serviceAddress);
}
