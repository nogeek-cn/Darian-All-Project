package com.gupao.study.vip;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class TCPServverDoubleDemo {

    public static void main(String[] args) {
        ServerSocket server= null;
        try {
            server=  new ServerSocket(8080);
            Socket socket = server.accept();
            BufferedReader BR = new BufferedReader(
                    new InputStreamReader(socket.getInputStream() ));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            //拿到控制台的信息
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in));
            // 拿到客户端的信息
            System.out.println("Client:"+ bufferedReader.readLine());

            String line = bufferedReader.readLine();
            while (!line.equals("bye")){
                // 输出数据
                printWriter.println(line);
                printWriter.flush();
                System.out.println("server:" + line);
                System.out.println("Client:"+bufferedReader.readLine());
                line = bufferedReader.readLine();
            }

            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
