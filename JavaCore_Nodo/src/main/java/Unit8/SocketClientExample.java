package Unit8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9245);
        System.out.println("CLIENT start sending..");

        try (DataInputStream input = (DataInputStream) socket.getInputStream();
             DataOutputStream ouput = (DataOutputStream) socket.getOutputStream()
        ){
            ouput.writeUTF("HELLO SERVER");
            System.out.println("SERVER Say: "+input.readUTF());
        }finally {
            socket.close();
        }
    }
}
