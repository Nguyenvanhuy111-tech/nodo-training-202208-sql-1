package Unit03_Collection_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,3,4,5,3,5,7,8);
        System.out.println("Before remove : size of list ="+ list.size());
//        for (int i =0;i<list.size();i++){
//            if(list.get(i)==3){
//                list.remove(i);
//            }
//
//        }

        list.forEach((Integer v)->{
            if (v != 3){
//                list.remove(v);
//                System.out.println();
            }
        });
//        System.out.println("After remove : size of list = "+list.size());

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next()==3){
//                iterator.remove();
//            }
//        }
//        list.removeIf(item ->{
//            return item==3;
//        });

        list.removeAll(Collections.singleton(3));
        System.out.println("After remove : size of list = "+list.size());
    }
}