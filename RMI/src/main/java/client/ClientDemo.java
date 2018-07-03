package client;

import com.gupao.study.vip.HelloServiceImpl;
import com.gupao.study.vip.IHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLOutput;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class ClientDemo {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

       IHelloService helloService =
               (IHelloService) Naming.lookup("rmi://127.0.0.1/hello");
       // HelloServiceImpl实例（HelloServiceImpl_stub）
        // RegistryImpl_stub

        System.out.println(helloService.sayHello("Daian"));

    }
}
