package Unit9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionTest {
    public static void main(String[] args) {
        String[] names = {"TRan Van A","Nguyen Van B","Nguyen THi C","Ta Van C"};
        int[] ages={23,45,12,67};

        IntStream intStream = IntStream.rangeClosed(0, names.length-1);
        Stream<Student> stream = intStream.mapToObj(value -> new Student(ages[value],names[value]));

        Consumer<Student> c = (Student student)->{
            System.out.println(student);
        };
//        stream.forEach(c);

//------------------------------------------------------------------------------------------------------------------------------------

//        List<Student> students = new ArrayList<>();
//        Consumer<Student> c = (Student student)->{
//            if (student.getAge()>23){
//                student.setAge(23);
//                students.add(student);
//            };
//        };
//        c.accept(new Student(24,"Nguyen A"));
//        System.out.println(students.get(0));



//------------------------------------------------------------------------------------------------------------------------------------
//Consumer<Student> c2 = System.out::println;

        Function<Student,String>jsonToFunction = (Student student)->{
            StringBuilder builder =new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid:").append(student.getId()).append("\n");
            builder.append("\tname:").append(student.getName()).append("\n");
            builder.append("\tage:").append(student.getAge()).append("\n");
            builder.append("}");
            return builder.toString();
        };

        c =(Student student)->{
            System.out.println(jsonToFunction.apply(student));
        };
//        stream.forEach(c);

//------------------------------------------------------------------------------------------------------------------------------------
        Predicate<Student> predicate =(Student student)->{
            return student.getAge()>30;
        };
        Stream<Student> older = stream.filter(predicate);
        older.forEach(c);
    }
}
