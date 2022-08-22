package Unit8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class DatagramServerExample implements Runnable{
    public DatagramServerExample() throws SocketException {
        DatagramSocket socket = new DatagramSocket(4445);
        System.out.println("DATA SERvER listening...");
    }

    @Override
    public void run() {
        DatagramSocket socket = null;
        try {
            byte[] bytes = new byte[1110];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            try {
                socket = new DatagramSocket();
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("FROM Client: " + new String(packet.getData(), 0, packet.getLength()));
            bytes = "SERVER SAY HELLO".getBytes();
            try {
                socket.send(new DatagramPacket(bytes,
                        bytes.length, packet.getAddress(), packet.getPort()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws SocketException {
        new Thread(new DatagramServerExample()).start();
    }
}
