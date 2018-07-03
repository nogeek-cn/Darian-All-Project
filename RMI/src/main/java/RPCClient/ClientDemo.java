package RPCClient;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class ClientDemo {

    public static void main(String[] args) {
        RpcclientProxy rpcclientProxy = new RpcclientProxy();

        IGPHello IGPHello = rpcclientProxy.clientProxy
                (IGPHello.class, "localhost", 8888);

        System.out.println(IGPHello.sayHello("Darian"));
    }
}
