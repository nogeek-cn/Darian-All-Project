package com.gupao.study.vip;

public interface ISerializer {

    /**
     * <br>方法说明 :序列化
     * <br>传入参数：
     * <br>返回值：
     * <br>作者：Darian
     **/
    <T> byte[] serializer(T obj);

    /**
     * <br>方法说明 :反序列化
     * <br>传入参数：
     * <br>返回值：
     * <br>作者：Darian
     **/
    <T> T doSerializer(byte[] data, Class<T> clazz);
}