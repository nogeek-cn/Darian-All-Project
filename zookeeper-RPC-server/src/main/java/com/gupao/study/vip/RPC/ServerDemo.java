package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.zk.IregisterCenter;
import com.gupao.study.vip.RPC.zk.IregisterCenterImpl;

import java.io.IOException;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class ServerDemo {

    public static void main(String[] args) throws IOException {
        // 发布一个服务
        IGPHello iGPHello = new IGPHelloImpl();

        IregisterCenter iregisterCenter = new IregisterCenterImpl();

        RPCServer rpcServer = new RPCServer(iregisterCenter,"127.0.0.1:8080");
        rpcServer.bind(iGPHello);

        rpcServer.publisher( );

        System.in.read();
    }
}
