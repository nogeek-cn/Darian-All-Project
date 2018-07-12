package com.gupao.study.vip.RPC.zk.loacBalance;

import java.util.List;
import java.util.Random;

/**
 * <br>类说明 : 随机负载均衡机制
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class RandomLoadBanlance extends  AbstractLoadBlance{
    @Override
    protected String doSlect(List<String> repos) {
        int len = repos.size();
        Random random = new Random();
        return repos.get(random.nextInt(len));
    }
}
