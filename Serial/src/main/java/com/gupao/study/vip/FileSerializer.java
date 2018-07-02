package com.gupao.study.vip;

import java.io.*;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class FileSerializer implements ISerializer {

    @Override
    public <T> byte[] serializer(T obj) {

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("user")));
            objectOutputStream.writeObject(obj);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> T doSerializer(byte[] data, Class<T> clazz) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("user")));
            return (T)objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(objectInputStream!=null){
                    objectInputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
