package Unit6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadPoolTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Executor execute = Executors.newFixedThreadPool(5);
        IntStream.range(0,6).forEach(i->{((ExecutorService) execute).submit(number);});
    }
}
