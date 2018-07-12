package com.gupao.study.vip.RPC.zk.loacBalance;

import org.jboss.netty.util.ThreadRenamingRunnable;

import javax.xml.ws.Response;
import java.util.List;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public abstract class AbstractLoadBlance implements LoadBalance {

    @Override
    public String selectHost(List<String> repos) {
        if (repos == null || repos.size() == 0) {
            return null;
        }
        if (repos.size() == 1) {
            return repos.get(0);
        }
        return doSlect(repos);
    }

    /**
     * <br>方法说明 :通过模板方法去扩展对应的负载操作去做一个选择
     * <br>常用的负载
     * <br>1. 随机
     * <br>2. 权重
     * <br>3. 轮询
     *
     * <br>传入参数：
     * <br>返回值：
     * <br>作者：Darian
     **/
    protected abstract String doSlect(List<String> repos);
}
