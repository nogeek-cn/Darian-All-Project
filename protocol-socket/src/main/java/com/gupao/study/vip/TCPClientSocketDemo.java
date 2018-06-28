package com.gupao.study.vip;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class TCPClientSocketDemo {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("127.0.0.1",8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("Hello");
        }catch (Exception e){

        }finally {
            try {
                if(socket!=null)
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
