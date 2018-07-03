package RPCServer;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class ServerDemo {

    public static void main(String[] args) {
        // 发布一个服务
        IGPHello iGPHello = new IGPHelloImpl();
        RPCServer rpcServer = new RPCServer();
        rpcServer.publisher(iGPHello, 8888);
    }
}
