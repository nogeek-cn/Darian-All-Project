package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.anno.RPCAnnotation;
import com.gupao.study.vip.RPC.zk.IregisterCenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class RPCServer {

    // 创建一个线程
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    // 注册中心
    private IregisterCenter registerCenter;
    // 服务发布地址
    private String serviceAddress;

    // 存放服务名称和服务对象之间的关系
    Map<String, Object> handlerMap = new HashMap<>();

    public RPCServer(IregisterCenter registerCenter, String serviceAddress) {
        this.registerCenter = registerCenter;
        this.serviceAddress = serviceAddress;
    }

    /**
     * 定义一个方法去绑定当前的这个服务
     * 绑定服务的名称和服务的对象
     **/
    public void bind(Object... services) {
        for (Object serivce : services) {
            RPCAnnotation annotation = serivce.getClass().getAnnotation(RPCAnnotation.class);
            // 服务的名称
            String serviceName = annotation.value().getName();
            // 绑定服务接口名称对应的服务
            handlerMap.put(serviceName, serivce);
        }
    }

    public void publisher() {
        ServerSocket serverSocket = null;
        try {
            String[] addrs = serviceAddress.split(":");
            // 启动一个服务监听
            serverSocket = new ServerSocket(Integer.parseInt(addrs[1]));

            for (String interfacename : handlerMap.keySet()) {
                registerCenter.register(interfacename, serviceAddress);

                System.out.println("服务注册成功"
                        + interfacename + "-->>" + serviceAddress);
            }

            while (true) {
                // 拿到一个请求
                Socket socket = serverSocket.accept();

                // 提交一个任务
                executorService.execute(new ProcessorHandler(socket, handlerMap));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
