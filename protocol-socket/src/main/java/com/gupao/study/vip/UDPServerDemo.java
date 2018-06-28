package com.gupao.study.vip;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class UDPServerDemo {
    public static void main(String[] args) throws Exception {

        // 基于UDP去做传输的,创建一个服务，并且接收一个数据包
        DatagramSocket datagramSocket = new DatagramSocket(8080);
        byte[] receiveData = new byte[1024];
        // 定义接收的数据包
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
        //
        datagramSocket.receive(receivePacket);

        System.out.println(new String(receiveData,0,receivePacket.getLength()));
    }
}
