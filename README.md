新建工程
=====================================================
2018.06.28

protocol-socket socket通信，UDP,TCP,TCP双向通道

https://github.com/Darian1996/Darian-All-Project/tree/master/protocol-socket/src/main/java/com/gupao/study/vip

-----------------------------------------------------
serial  序列化，反序列化

深度克隆，浅克隆
序列化，反序列化
transient
static

-------------------------------------------------
RMI

jva_RMI
手写RPC框架
https://github.com/Darian1996/Darian-All-Project/tree/master/

RMIClient
手写RPC框架客户端

注意：
序列化和反序列化的时候，包名和类型必须完全一样

---------------------------------------------------
APIzookeeper-curator

zookeeperAPI实现监听，增删改查，监听创建的事件。
watcher事件的循环监听

利用curator实现节点的增删改查，还有事件的监听

---------------------------------------------------

zookeeper-RPC

DistributeLock
  利用zookeeper 的 API 实现了分布式锁
TestDistributeLock 
测试

curatorDemo
利用 Curator 实现了分布式锁


zookeeper-RPC-server
利用 zookeeper 实现简单的 RPC 框架 服务端

zookeeper-RPC-Client
利用 zookeeper 实现简单的 RPC 框架 客户端

locaBalance
实现了负载均衡

----------------------------------------------------

dubbo分布式治理初探

分布式治理初探-dubboClient 客户端

分布式治理初探-dubboServer 服务端

内部实现了随机负载均衡调用，

实现了多协议支持

注意：
为文件夹格式，dubbboClient和DubboServer都是一个独立的项目





