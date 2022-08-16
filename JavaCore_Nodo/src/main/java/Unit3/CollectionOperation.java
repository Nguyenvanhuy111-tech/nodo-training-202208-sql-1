package Unit3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
//        --CollectionOperation 1
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
//        Comparator<Integer> comparator = Integer::compare;
//        Collections.sort(listOfIntegers, comparator);
//        listOfIntegers.stream().filter(v -> v > 5).forEach(System.out::println);
//
////        CollectionOperation 2
//        Collector<Integer, ?, IntSummaryStatistics> collector =
//                Collectors.summarizingInt(Integer::intValue);
//        IntSummaryStatistics summaryStatistics = listOfIntegers.stream().collect(collector);
//        System.out.println("total = " + summaryStatistics);
//        System.out.println("Overage = " + summaryStatistics.getAverage());
//
////        CollectionOperation 3
//        Consumer<Integer> myConsumer = n -> {
//            System.out.println("User input value = " + n);
//            if (n < 5) {
//                System.out.println("Invalid value!");
//                return;
//            }
//            listOfIntegers.add(n);
//            System.out.println("value: ");
//            listOfIntegers.forEach(x -> System.out.print(x + "-"));
//        };
//        myConsumer.accept(15);
//
//        //    CollectionOperation 4
        Scanner s = new Scanner(System.in);
//        while (true) {
//            System.out.print("Please in put a number: ");
//            Integer value = s.nextInt();
//            myConsumer.accept(value);
//            System.out.println();
//        }

        //    CollectionOperation 5
        Predicate<Integer> tester = integer -> (integer>5);
        Consumer<Integer> myConsumer = n->listOfIntegers.add(n);
        while (true){
            System.out.print("Please in put a number: ");
            int value = s.nextInt();
            if (value<0) break;
            if (tester.test(value)) myConsumer.accept(value);
        }
        listOfIntegers.forEach(x-> System.out.println(x+"-"));
    }
}
