package Unit1;

public class SwitchExample {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        switch (value){
            case 0:
                System.out.println("Bad");
                break;
            case 1:
                System.out.println("Ok");
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }
}
