package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.anno.RPCAnnotation;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
@RPCAnnotation(IGPHello.class)
public class IGPHelloImpl implements IGPHello {

    @Override
    public String sayHello(String msg) {
        return "hello, " + msg;
    }
}
