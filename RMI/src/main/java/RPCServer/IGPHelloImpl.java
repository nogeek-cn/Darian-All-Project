package RPCServer;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class IGPHelloImpl implements IGPHello {


    @Override
    public String sayHello(String msg) {
        return "hello, " + msg;
    }
}
