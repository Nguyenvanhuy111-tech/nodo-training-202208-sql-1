package Unit3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionExample1 {
    public static void main(String[] args) {
        Short[] values = {1,2,3,4,5,6,7,8,9};

        List<Short> list = new ArrayList<>();
        Collections.addAll(list,values);

        Collections.reverse(list);

        list.toArray(values);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(values[i]+",");
        }
    }
}
