package Unit3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionExample2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Tu","An","Hoa","Binh");

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+",");
        }
        System.out.println();

        System.out.println("VI tri thu "+(Collections.binarySearch(list,"Hoa")+1));
    }
}
