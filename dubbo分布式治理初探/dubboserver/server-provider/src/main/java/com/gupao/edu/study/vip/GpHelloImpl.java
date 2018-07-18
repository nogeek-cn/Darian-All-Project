package com.gupao.edu.study.vip;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class GpHelloImpl implements IGpHello {

    @Override
    public String sayHello(String msg) {
        return "hello:--" + msg;
    }
}
