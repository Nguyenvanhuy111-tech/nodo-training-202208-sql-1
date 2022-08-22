package Unit8;

import java.rmi.RemoteException;

public class Server implements Hello{
    @Override
    public String say(String name) throws RemoteException {
        return "Hello: "+name;
    }

//    public static void main(String[] args) {
//        System.setProperties("java.rmi.server.hostname","127.0.0.1");
//
//    }
}
