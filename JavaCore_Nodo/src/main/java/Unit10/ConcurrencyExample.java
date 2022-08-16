package Unit10;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {
    static List<Integer> list = null;

    public static void addData(List list) {
        try {
            while (true) {
                int random = (int) (Math.random() * 100);
                list.add(random);
                System.out.println("Add new Data " + random);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printData(List list){
        while (true){
            try {
                System.out.println("=============================");
                list.forEach(v-> System.out.println("value= "+v));
                Thread.sleep(80);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        list = new ArrayList<>();
        new Thread(() -> {
            addData(list);
        }).start();
        new Thread(() -> {
            printData(list);
        }).start();

    }
}
