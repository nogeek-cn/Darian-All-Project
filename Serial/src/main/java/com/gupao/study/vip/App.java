package com.gupao.study.vip;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        // serialVersionId的序列化
        ISerializer iSerializer = new FileSerializer();
        User user = new User();
        user.setAge(18);
        user.setName("Dairan");

        XmlSerial xmlSerial = new XmlSerial();
        byte[] serializer = xmlSerial.serializer(user);
        System.out.println(new String(serializer));


        // iSerializer.serializer(user);

        // serialVersionUID的反序列化

      /*  User user = iSerializer.doSerializer(null, User.class);
        System.out.println(user);
*/
 /*
        // 没有serialVersionID的序列化
        ISerializer iSerializer = new JavaSerializer();
        User user = new User();
        user.setAge(18);
        user.setName("Dairan");

        byte[] bytes =  iSerializer.serializer(user);


        System.out.println(bytes);
// 没有serialVersionID的反序列化
        User user1 = iSerializer.doSerializer(bytes, User.class);
        System.out.println(user1);
*/

    }
}
