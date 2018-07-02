package com.gupao.study.vip;

import lombok.Data;

import java.io.*;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
@Data
public class Person implements Cloneable, Serializable {
    private String name;
    private Email email;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }

    public Person deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Person)objectInputStream.readObject();
    }
}
