package com.gupao.study.vip;

import com.sun.javafx.image.ByteToBytePixelConverter;

import java.io.IOException;
import java.net.*;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class UDPClientDemo {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        byte[] sendData = "Hello, Darian".getBytes();
        DatagramPacket sendPacket = new
                DatagramPacket(sendData, sendData.length,address,8080);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(sendPacket);

    }
}
