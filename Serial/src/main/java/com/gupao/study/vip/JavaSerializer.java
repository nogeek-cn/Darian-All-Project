package com.gupao.study.vip;



import java.io.*;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class JavaSerializer implements ISerializer {

    @Override
    public <T> byte[] serializer(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }

                byteArrayOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> T doSerializer(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T)objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(objectInputStream!=null){
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
