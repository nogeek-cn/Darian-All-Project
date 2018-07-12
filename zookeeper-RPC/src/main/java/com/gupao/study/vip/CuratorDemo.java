package com.gupao.study.vip;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class CuratorDemo {
    public static void main(String[] args) {

        /**
         * 获取分布式锁，
         * 是利用最小节点的特性去实现的
         * InterProcessMutex 是个可重入锁
         *
         **/
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder().build();
        InterProcessMutex interProcessMutex =
                new InterProcessMutex(curatorFramework,"/locks");

        try {
            // 去获得锁
            interProcessMutex.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
