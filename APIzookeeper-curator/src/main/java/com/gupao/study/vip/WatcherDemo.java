package com.gupao.study.vip;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class WatcherDemo {
    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final ZooKeeper zooKeeper =
                    new ZooKeeper("192.168.136.128:2181," +
                            "192.168.136.129:2181," +
                            "192.168.136.130:2181",
                            4000, new Watcher() {
                        // 为了保证连接的成功状态
                        @Override
                        public void process(WatchedEvent watchedEvent) {
                            System.out.println("全局的默认的watcher事件："
                                    + watchedEvent.getType()
                                    + "----->>>>>>"
                                    + watchedEvent.getPath());
                            // 连接成功以后触发watcher事件
                            if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                                // 如果收到了服务端的响应事件，连接成功
                                // 连接成功以后做一个递减。
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();

            zooKeeper.create("/zk-tmp-darian", "1".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            // exists   getdata getchildren

            // 绑定事件
            // 我们在创建zookeeper的时候创建了一个默认的匿名内部类，
            // 如果说设置成 true 的话，所有的事件都会触发到内部类里边
            // zooKeeper.exists("/zi-tmp-darian",true);

            // 绑定自己的watcher事件
            // 通过 exists 绑定事件
            Stat stat = zooKeeper.exists("/zk-tmp-darian", new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getType() + "--->>>>" + watchedEvent.getPath());

                    try {
                        // 通过再一次绑定事件去实现永久监听的一个效果
                        zooKeeper.exists(watchedEvent.getPath(), true);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // 通过修改的食物类型操作来触发监听事件
            stat = zooKeeper.setData("/zk-tmp-darian", "222".getBytes(), stat.getVersion());

            Thread.sleep(1000);

            zooKeeper.delete("/zk-tmp-darian", stat.getVersion());

            System.in.read();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
