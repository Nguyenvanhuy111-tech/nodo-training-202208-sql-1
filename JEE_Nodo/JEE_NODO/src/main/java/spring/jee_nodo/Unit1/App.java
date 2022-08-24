package spring.jee_nodo.Unit1;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.jee_nodo.JeeNodoApplication;

public class App {
    private final static Logger LOGGER =Logger.getLogger(String.valueOf(HelloWorld.class));
    public static void main(String[] args) {
        SpringApplication.run(JeeNodoApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        HelloClazz obj = (HelloClazz)context.getBean("helloJavaClazz");
//        obj.printMessage();
//
//        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
//        obj2.printMessage();
//        System.out.println(obj2==obj2);
//
//        context.registerShutdownHook();
//
//       HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//         helloWorld.sayHello();

        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
        LOGGER.info("Map Implement is "+clazz.getStudents().getClass());
        LOGGER.info("There are "+clazz.getStudents().size()+" in the class");
    }
}

