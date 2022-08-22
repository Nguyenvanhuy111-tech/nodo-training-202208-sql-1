package Unit6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReadWriterLockExample {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        Map<String,String> map = new HashMap<>();
        ((ExecutorService) executor).submit(()->{
            System.out.println("Start writing");
            try {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    map.put("foo","bar");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }finally {
                System.out.println("End writing");
            }
        });
    }
}
