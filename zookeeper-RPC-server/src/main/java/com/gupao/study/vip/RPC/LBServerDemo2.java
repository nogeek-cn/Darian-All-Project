package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.zk.IregisterCenter;
import com.gupao.study.vip.RPC.zk.IregisterCenterImpl;

import java.io.IOException;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class LBServerDemo2 {

    public static void main(String[] args) throws IOException {
        // 发布一个服务
        IGPHello igpHello2 = new IGPHelloImpl();

        IregisterCenter iregisterCenter = new IregisterCenterImpl();

        RPCServer rpcServer = new RPCServer(iregisterCenter,"127.0.0.1:8081");
        rpcServer.bind(igpHello2);

        rpcServer.publisher( );

        System.in.read();
    }
}
