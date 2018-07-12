package com.gupao.study.vip;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class CuratorDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory
                .builder()
                .connectString("192.168.136.128:2181," +
                        "192.168.136.129:2181," +
                        "192.168.136.130:2181")
                .sessionTimeoutMs(4000)
                // 一个重试机制，递减的重试机制
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                // 指定命名空间，我们会把某个业务放在一个大的命名空间下面
                // 因为我们要区分每个场景下的业务划分
                .namespace("/curator")
                .build();

        curatorFramework.start();

        // 创建结果： /curator/darian/node1
        // 原生的 API 中，必须是逐层创建，也就是父节点必须存在，子节点才能创建
        curatorFramework.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/darian/node1", "2".getBytes());

        // 查询节点，得到节点的 Stat 信息
        Stat stat = new Stat();
        curatorFramework.getData()
                .storingStatIn(stat)
                .forPath("/darian/node1");

        // 更新操作
        curatorFramework.setData()
                .withVersion(stat.getVersion())
                .forPath("/darian/node1", "232".getBytes());


        // 去删除某个节点
        curatorFramework.delete()
                .deletingChildrenIfNeeded()
                .forPath("/darian/node1");
    }
}
