package com.gupao.study.vip;

import jdk.nashorn.internal.ir.JumpToInlinedFinally;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class TCPServerSocketDemo {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;


        try {
            serverSocket = new ServerSocket(8080);

            // 阻塞
            Socket socket = serverSocket.accept();// 等待客户端连接
            // 获得输入流
            bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // 写到控制台
            System.out.println(bufferedReader.readLine());

            // 得到输出流（可以进行通信）
            socket.getOutputStream();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

}
