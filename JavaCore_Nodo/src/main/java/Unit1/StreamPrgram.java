package Unit1;

import java.util.Arrays;

public class StreamPrgram {
    public static void main(String[] args) {
        System.out.println("Print length of arguments");
        Arrays.stream(args).forEach((String value)->{
            System.out.println("Value is "+value);
        });
    }
}
