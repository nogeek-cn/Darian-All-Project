package com.gupao.study.vip.RPC.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class IregisterCenterImpl implements IregisterCenter {

    private CuratorFramework curatorFramework;

    {
        curatorFramework = CuratorFrameworkFactory
                .builder()
                .connectString(zkConfig.CONNECTION_STRING)
                .sessionTimeoutMs(4000)
                .retryPolicy(
                        new ExponentialBackoffRetry(
                                1000, 10))
                .build();

        curatorFramework.start();
    }

    @Override
    public void register(String serviceName, String serviceAddress) {
        // 注册相应的服务
        String serverPath = zkConfig.ZK_REGISTER_PATH + "/" + serviceName;

        try {
            // 先判断 /registrys/prodect-service 是否存在，不存在则创建
            if (curatorFramework.checkExists().forPath(serverPath) == null) {
                // 如果当前节点的父节点不存在，就去创建一个父节点
                curatorFramework.create().creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .forPath(serverPath, "0".getBytes());
            }

            // 绑定服务的地址
            String addressPath = serverPath + "/" + serviceAddress;
            String rsNode = curatorFramework.create()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(addressPath, "0".getBytes());

            System.out.println("服务注册成功：" + rsNode );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
