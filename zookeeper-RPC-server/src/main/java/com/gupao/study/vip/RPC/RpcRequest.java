package com.gupao.study.vip.RPC;

import lombok.Data;

import java.io.Serializable;

/**
 * <br>类说明 :因为要远程传输，所以要实现serializable
 * 它是我们的传输对象
 * 服务端也需要拿到这样一个对象去序列化
 *
 * <br>属性说明：
 *
 * <br>作者：Darian
 **/
@Data
public class RpcRequest implements Serializable {

    // 远程传输这个对象需要被序列化
    private static final long serialVersionUID = -7163304417540104407L;

    // 告诉它我要调用的是哪个方法，我当前调用的参数是什么，当前调用是哪个服务。
    private String className;
    private String methodName;
    private Object[] parameters;
    private String version;

}
