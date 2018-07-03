package RPCClient;


import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class TCPTransport {

    private String host;

    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket(){
        System.out.println("创建一个新的连接");
        Socket socket;

        try {
            socket = new Socket(host,port);
            return socket;
        } catch (IOException e) {
            throw new RuntimeException("连接建立失败");
        }
    }

    // 在TCP传输层做一个send操作
    public Object send(RpcRequest request){
        Socket socket = null;

        try {
            socket = newSocket();
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);// 序列化 RpcRequest已经实现了序列化
                                                  // 接收端 接收以后就可以反序列化

            objectOutputStream.flush();
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(socket.getInputStream());

            // 两个流关闭掉
            objectInputStream.close();
            objectOutputStream.close();

            Object result = objectInputStream.readObject();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("发起远程调用异常：", e);
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
