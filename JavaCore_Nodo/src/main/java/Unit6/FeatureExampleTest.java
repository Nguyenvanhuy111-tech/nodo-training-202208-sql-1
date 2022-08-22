package Unit6;

import java.util.concurrent.*;

public class FeatureExampleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableSample callableSample = new CallableSample();

       Executor excutor = Executors.newFixedThreadPool(1);
        Future future= ((ExecutorService) excutor).submit(callableSample);

        System.out.println("Future DOne ?"+future.isDone());
        Object result = future.get();
        System.out.println("Future DOne ?"+future.isDone()+"-result= "+result);
    }
}
