package com.gupao.study.vip;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <br>类说明 :
 * 基于 Lock 来实现分布式锁，
 *
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class DistributedLock implements Lock, Watcher {

    // 首先定义一个 zookeeper 的连接
    private ZooKeeper zooKeeper = null;
    // 定义根节点
    private String ROOT_LOCK = "/locks";
    // 等待前一个锁 ，得到监控的前一个锁的节点
    private String WAIT_LOCK;
    // 表示当前的锁
    private String CURRENT_LOCK;

    // 用来做处理
    private CountDownLatch countDownLatch;

    public DistributedLock() {
        try {
            zooKeeper = new ZooKeeper("192.168.136.128:2181",
                    4000, this);

            // 判断根节点是否存在
            Stat stat = zooKeeper.exists(ROOT_LOCK, false);
            if (stat == null) {
                // 当前的节点是不存在的
                zooKeeper.create(ROOT_LOCK, "0".getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lock() {
        if (this.tryLock()) {
            // 如果获得锁成功
            System.out.println(Thread.currentThread().getName()
                    + "-->>"
                    + CURRENT_LOCK
                    + "获得锁成功");
            return;
        }
        // 没有获得锁，继续等待获得锁
        try {
            waitForLock(WAIT_LOCK);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这是一个持续阻塞去获得所得一个过程
     **/
    private boolean waitForLock(String prev) throws KeeperException, InterruptedException {
        // 因为我要等待锁的话，我需要监听上一个锁的节点
        // 通过 exists 去监听
        // 监听当前节点的上一个节点
        Stat stat = zooKeeper.exists(prev, true);
        if (stat != null) {
            // 表示上一个节点确实存在
            System.out.println(Thread.currentThread().getName()
                    + "-->>等待锁"
                    + ROOT_LOCK
                    + "/"
                    + prev
                    + "释放");
            countDownLatch = new CountDownLatch(1);
            countDownLatch.await();

            System.out.println(Thread.currentThread().getName()
                    + "-->>获得锁成功");
        }
        return true;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {

        try {
            // 创建临时有序节点
            CURRENT_LOCK = zooKeeper.create(ROOT_LOCK + "/", "0".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);

            System.out.println(Thread.currentThread().getName()
                    + "-->>"
                    + CURRENT_LOCK
                    + "尝试去竞争锁");

            // 获取根节点下的所有子节点
            List<String> childrens = zooKeeper.getChildren(ROOT_LOCK, false);
            // 定义一个集合进行排序
            SortedSet<String> sortedSet = new TreeSet<>();
            for (String children : childrens) {
                sortedSet.add(ROOT_LOCK + "/" + children);
            }
            // 获得所有子节点中最小的节点
            String firstnode = sortedSet.first();

            SortedSet<String> lessThenMe = ((TreeSet<String>) sortedSet).headSet(CURRENT_LOCK);

            if (CURRENT_LOCK.equals(firstnode)) {
                // 通过当前的节点和子节点中最小的节点进行比较，如果相等，标识获得锁成功
                return true;
            }
            if (!lessThenMe.isEmpty()) {
                // 如果没有比自己更小的节点
                // 获得比当前节点更小的最后一个几点，设置给WAIT_LOCK
                WAIT_LOCK = lessThenMe.last();
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        // 释放锁
        System.out.println(Thread.currentThread().getName()
                + "-->>释放锁"
                + CURRENT_LOCK);
        try {
            // 删除掉这个节点，version = -1 表示不管三七二十一都删掉
            zooKeeper.delete(CURRENT_LOCK, -1);
            CURRENT_LOCK = null;
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        // 在这里边去处理监听事件
        if (this.countDownLatch != null) {
            // 去释放锁
            this.countDownLatch.countDown();
        }
    }
}
