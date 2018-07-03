package com.gupao.study.vip;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class Server {

    public static void main(String[] args) {

        try {
            IHelloService helloService = new HelloServiceImpl();
            // 已经发布了一个远程对象

            LocateRegistry.createRegistry(1099);

            // 有点像注册中心   key-value
            Naming.rebind("rmi://127.0.0.1/hello", helloService);

            System.out.println("服务启动成功");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
