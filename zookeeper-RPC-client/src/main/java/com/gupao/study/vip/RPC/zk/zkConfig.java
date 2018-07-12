package com.gupao.study.vip.RPC.zk;

import lombok.Data;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
@Data
public class zkConfig {

    public final static String CONNECTION_STRING
            = "192.168.136.128:2181,"
            + "192.168.136.129:2181,"
            + "192.168.136.130:2181";

    public final static String ZK_REGISTER_PATH = "/registrys";

}
