package com.gupao.study.vip;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class TCPClientDoubleDemo {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            BufferedReader bufferedReaderIn = new BufferedReader(
                    new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReaderOut = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String line = bufferedReaderIn.readLine();
            while (!line.equals("bye")){
                printWriter.println(line);
                printWriter.flush();
                System.out.println("Client:"+line);
                System.out.println("Server:"+bufferedReaderOut.readLine());
                line = bufferedReaderIn.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
