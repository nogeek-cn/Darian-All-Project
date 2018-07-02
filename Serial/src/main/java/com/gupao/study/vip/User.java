package com.gupao.study.vip;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
@Data
public class User extends superClass implements Serializable {

    private static final long serialVersionUID = -281884127299001746L;
 //   private static final long serialVersionUID = -1L;
    private static Integer b = 5;

    private Integer age;
    private String name;

    private transient  String hobby;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        // 绕过 transient 实现序列化
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(hobby);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        // 绕过 transient 实现反序列化
        objectInputStream.defaultReadObject();
        hobby = (String)objectInputStream.readObject();
    }
}
