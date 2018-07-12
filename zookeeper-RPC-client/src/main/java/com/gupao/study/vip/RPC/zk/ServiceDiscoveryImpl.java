package com.gupao.study.vip.RPC.zk;

import com.gupao.study.vip.RPC.zk.loacBalance.LoadBalance;
import com.gupao.study.vip.RPC.zk.loacBalance.RandomLoadBanlance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class ServiceDiscoveryImpl implements IServiceDiscovery {

    // 定义一个全局的协议地址
    List<String> repos = new ArrayList<>();

    private CuratorFramework curatorFramework;

    private String address;

    public ServiceDiscoveryImpl(String address) {
        this.address = address;

        curatorFramework = CuratorFrameworkFactory
                .builder()
                .connectString(address)
                .sessionTimeoutMs(4000)
                .retryPolicy(
                        new ExponentialBackoffRetry(
                                1000, 10))
                .build();

        curatorFramework.start();
    }


    @Override
    public String discover(String serviceName) {
        // 先去根据当前的路径得到所有的节点,所有协议地址
        String path = zkConfig.ZK_REGISTER_PATH + "/" + serviceName;

        System.out.println("服务在zookeeper上的地址：" + path);

        try {
            repos = curatorFramework.getChildren().forPath(path);
            // 如果服务端注册成功，我一定可以拿到两个地址


        } catch (Exception e) {
            throw new RuntimeException("获取子节点异常：" + e.getMessage());
        }

        // 动态发现服务节点的变化
        registerWatcher(path);

        // 负载均衡机制
        LoadBalance loadBalance = new RandomLoadBanlance();

        // 返回了调用的服务地址
        return loadBalance.selectHost(repos);
    }

    private void registerWatcher(final String path) {
        PathChildrenCache childrenCache = new PathChildrenCache(
                curatorFramework, path, true);

        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                repos = curatorFramework.getChildren().forPath(path);
            }
        };
        childrenCache.getListenable().addListener(pathChildrenCacheListener);

        try {
            childrenCache.start();
        } catch (Exception e) {
            throw new RuntimeException("注册PathChild Watcher 异常" + e);
        }
    }

}
