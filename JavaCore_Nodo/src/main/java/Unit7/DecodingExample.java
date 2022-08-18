package Unit7;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecodingExample {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int[] values = {120, 105, 110, 32, 99, 104, -61, -96, 111};
        byte[] bytes = new byte[]{};
        List<Object> list = new ArrayList<>();
        byte b;
        for (int i = 0; i < values.length; i++) {
            b = (byte) values[i];
            list.add(b);
        }
        for (int i = 0; i < list.size(); i++) {
            bytes = new byte[]{(byte) list.get(i)};
            System.out.print(new String(bytes, "utf8"));
        }
    }
}
