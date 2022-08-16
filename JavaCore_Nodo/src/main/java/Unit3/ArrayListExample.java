package Unit3;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,args);

//        IntStream.range(0,list.size()).forEach(i->{
//            System.out.println("Element at "+i+" is "+list.get(i));
//        });

        list=new LinkedList<>(Arrays.asList(args));
        list.forEach(System.out::println);
    }
}
