package com.gupao.study.vip.RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * <br>类说明 :专门的任务处理
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class ProcessorHandler implements Runnable {

    private Socket socket;

    Map<String, Object> handleMap;

    public ProcessorHandler(Socket socket, Map<String, Object> handleMap ) {
        this.socket = socket;
        this.handleMap = handleMap;
    }

    @Override
    public void run() {
        // 去处理我们的请求
        // 怎么拿到我们的对象
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            // 读取远程传输过来的对象 可以
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();

            //通过反射去调用本地的方法
            Object result = invoke(rpcRequest);

            //通过输出流讲结果输出给客户端
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);

            objectOutputStream.flush();
            objectOutputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 利用反射调用相应的方法
    private Object invoke(RpcRequest request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[] parameters = request.getParameters();
        Class<?>[] types = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            types[i] = parameters[i].getClass();
        }

        // 从 handleMap 中，根据服务端请求的地址，去拿到相应的服务，通过反射发起调用
        Object service = handleMap.get(request.getClassName());
        Method method = service.getClass().getMethod(request.getMethodName(), types);
        return method.invoke(service, parameters);

    }
}
