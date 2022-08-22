package Unit6;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InvokeAllExample
{
    Executor executor = Executors.newWorkStealingPool();
   Callable callables = (Callable) Arrays.asList(
           new CallableSample(),new CallableSample(),new CallableSample()
   );
    }
