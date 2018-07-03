package com.gupao.study.vip;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {

    // 远端调用异常的话，会抛出一个异常
    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String msg) throws RemoteException {
        return "Hello" + msg;
    }
}
