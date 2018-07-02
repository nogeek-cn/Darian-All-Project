package com.gupao.study.vip;

import java.io.*;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class StroreTuleDemo {

    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(new File("user")));
        User user = new User();
        user.setAge(18);
        user.setName("Dairan");
        user.setSex("男");

        objectOutputStream.flush();
        objectOutputStream.writeObject(user);
        System.out.println(new File("user").length());

        objectOutputStream.flush();
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        System.out.println(new File("user").length());
    }
}
