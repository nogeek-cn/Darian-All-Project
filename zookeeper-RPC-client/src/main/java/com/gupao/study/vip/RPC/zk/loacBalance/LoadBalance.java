package com.gupao.study.vip.RPC.zk.loacBalance;

import java.util.List;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作 者：Darian
 **/
public interface LoadBalance {

    String selectHost(List<String> repos);
}
