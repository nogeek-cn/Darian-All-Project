package com.gupao.study.vip.RPC;

import com.gupao.study.vip.RPC.anno.RPCAnnotation;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
@RPCAnnotation(IGPHello.class)
public interface IGPHello {

    String sayHello(String msg);
}
