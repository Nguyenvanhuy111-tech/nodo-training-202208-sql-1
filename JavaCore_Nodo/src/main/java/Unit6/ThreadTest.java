package Unit6;

class ThreadTest {
    public static void main(String[] args) {
        PrintMessage message = new PrintMessage("Say hello to everyone");
        new Thread(message).start();
        new Thread(message).start();
    }
}