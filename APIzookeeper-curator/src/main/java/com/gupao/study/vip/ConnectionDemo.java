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
public class ConnectionDemo {
    public static void main(String[] args) {
        try {
            final CountDownLatch  countDownLatch = new CountDownLatch(1);
            ZooKeeper zooKeeper =
                    new ZooKeeper("192.168.136.128:2181," +
                            "192.168.136.129:2181," +
                            "192.168.136.130:2181",
                            4000, new Watcher() {
                        // 为了保证连接的成功状态
                        @Override
                        public void process(WatchedEvent watchedEvent) {
                            // 连接成功以后触发watcher事件
                            if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
                                // 如果收到了服务端的响应事件，连接成功
                                // 连接成功以后做一个递减。
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();

            System.out.println(zooKeeper.getState());//CONNECTED

            // 添加节点
            zooKeeper.create("/java-con-darian","232".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            Stat stat = new Stat();
            //Stat和我们在控制台看到的属性是一样的。
            // 得到节点的值
            byte[] dataBytes = zooKeeper.getData("/java-con-darian", null, stat);
            System.out.println(new String(dataBytes));

            Thread.sleep(1000);
            // 修改节点的值，乐观锁的概念
            zooKeeper.setData("/java-con-darian", "55".getBytes(),stat.getVersion());

            byte[] updateBytes = zooKeeper.getData("/java-con-darian", null, stat);
            System.out.println(new String(updateBytes));

            zooKeeper.delete("/java-con-darian", stat.getVersion());

            zooKeeper.close();

            // 当前线程进行阻塞
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
