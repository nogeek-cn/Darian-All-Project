package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.anno.RPCAnnotation;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
@RPCAnnotation(value = IGPHello.class,version = "2.0")
public class IGPHelloImpl2 implements IGPHello {

    @Override
    public String sayHello(String msg) {
        return "I'm version 2.0 ,hello, " + msg;
    }
}
