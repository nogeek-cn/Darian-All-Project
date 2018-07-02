package com.gupao.study.vip;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.time.chrono.IsoChronology;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class XmlSerial implements ISerializer {

    XStream xStream = new XStream(new DomDriver());

    @Override
    public <T> byte[] serializer(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T doSerializer(byte[] data, Class<T> clazz) {
        return (T)xStream.fromXML(new String(data));
    }
}
