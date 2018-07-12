package com.gupao.study.vip;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * <br>类说明 : 事件的高度封装
 * <p>
 * curator封装了三种事件的机制
 * PathChildCache   监听一个节点下节点的创建、删除、更新
 * NodeCache        监听一个节点的更新和创建事件
 * TreeCache        综合 PatchChildCache 和 NodeCache 的特性
 *
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class CuratorWatcherDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory
                .builder()
                .connectString("192.168.136.128:2181," +
                        "192.168.136.129:2181," +
                        "192.168.136.130:2181")
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("curator")
                .build();

        curatorFramework.start();


        // 当前节点的创建、删除事件监听
        // addListenerWithNodeCache(curatorFramework, "/darian");

        // 子节点的增加、修改、删除的事件监听
        // addlistenerWithPathChildCache(curatorFramework,"/darian");

        // 综合节点的监听事件
        addListerWithTreeCache(curatorFramework, "/darian");

        System.in.read();

    }

    /**
     * NodeCache + PathChildrenCache
     **/
     public static void addListerWithTreeCache(CuratorFramework curatorFramework, String path) throws Exception {
        final TreeCache treeCache = new TreeCache(curatorFramework,path);

        TreeCacheListener treeCacheListener = new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println(treeCacheEvent.getType()+"-->>"+treeCacheEvent.getData());
            }
        };

        treeCache.getListenable().addListener(treeCacheListener);
        treeCache.start();
        /*
        INITIALIZED-->>null
NODE_ADDED-->>ChildData{path='/darian', stat=51539607621,51539607621,1531222950294,1531222950294,0,0,0,0,1,0,51539607621
, data=[49]}
NODE_ADDED-->>ChildData{path='/darian/node1', stat=51539607622,51539607622,1531222969992,1531222969992,0,0,0,0,1,0,51539607622
, data=[49]}
NODE_ADDED-->>ChildData{path='/darian/node1/node1', stat=51539607623,51539607623,1531222989856,1531222989856,0,0,0,0,1,0,51539607623
, data=[49]}
NODE_REMOVED-->>ChildData{path='/darian/node1/node1', stat=51539607623,51539607623,1531222989856,1531222989856,0,0,0,0,1,0,51539607623
, data=[49]}
NODE_UPDATED-->>ChildData{path='/darian/node1', stat=51539607622,51539607625,1531222969992,1531223116477,1,2,0,0,1,0,51539607624
, data=[50]}
NODE_REMOVED-->>ChildData{path='/darian/node1', stat=51539607622,51539607625,1531222969992,1531223116477,1,2,0,0,1,0,51539607624
, data=[50]}
NODE_REMOVED-->>ChildData{path='/darian', stat=51539607621,51539607621,1531222950294,1531222950294,0,2,0,0,1,0,51539607626
, data=[49]}
         */
    }


    /**
     * 监听对应节点下的子节点的变化
     * 创建
     * 删除
     * 更新
     */
    public static void addlistenerWithPathChildCache(CuratorFramework curatorFramework, String path) throws Exception {
        final PathChildrenCache pathChildrenCache =
                new PathChildrenCache(curatorFramework, path, true);
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("receive Event:"
                        + pathChildrenCacheEvent.getType()
                        + "-->>"
                        + pathChildrenCacheEvent.getData());
            }
        };

        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
        /*
receive Event:CONNECTION_RECONNECTED-->>null
receive Event:CHILD_ADDED-->>ChildData{path='/darian/node1', stat=51539607611,51539607611,1531222192297,1531222192297,0,0,0,0,1,0,51539607611
, data=[49]}
receive Event:CHILD_REMOVED-->>ChildData{path='/darian/node1', stat=51539607611,51539607611,1531222192297,1531222192297,0,0,0,0,1,0,51539607611
, data=[49]}
         */
    }

    /**
     * 监听这个节点的变化
     * 创建
     * 更新
     **/
    public static void addListenerWithNodeCache(CuratorFramework curatorFramework, String path) throws Exception {
        final NodeCache nodeCache = new NodeCache(curatorFramework, path, false);

        NodeCacheListener nodeCacheListener = new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {

                System.out.println("Receive Event:" + nodeCache.getCurrentData().getPath());
            }
        };

        nodeCache.getListenable().addListener(nodeCacheListener);
        nodeCache.start();
    }
}
