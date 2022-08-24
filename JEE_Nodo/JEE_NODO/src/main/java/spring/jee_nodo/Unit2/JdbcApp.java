package spring.jee_nodo.Unit2;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class JdbcApp {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_jdbc.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
//        LOGGER.info("Create bean "+jdbc);
//        jdbc.insert("Tran Van B",24);
//        jdbc.updateAgeByName("Tran Van B",25);
//        List<Student> students = Arrays.asList(
//                new Student("Tran THi A",17),
//                new Student("Tran THi L",20),
//                new Student("Tran THi Z",25)
//        );
//        int[] values = jdbc.addStudent(students);
//        for (int i = 0; i < values.length; i++) {
//            LOGGER.info("Add record "+i+":"+(values[i]==0?"Failed":"Success"));
//        }
        jdbc.save("Tran Van THi A",23);
//        jdbc.loadStudent("B").forEach(student -> LOGGER.info(student));
//        LOGGER.info("Total student is "+jdbc.totalRecord());
    }
}
