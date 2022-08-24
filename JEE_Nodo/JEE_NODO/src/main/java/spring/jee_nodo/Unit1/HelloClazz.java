package spring.jee_nodo.Unit1;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean {
    private String message;
    private List<JavaClazz> clazzes;

    public HelloClazz(){
        message="From Constructor: Say hello everyone!";
    }
    //create getter and setter
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void printMessage(){
        System.out.println("Your Message: "+message);
    }

    public void initMessage() {
        System.out.println("Calling init method...");
        message= "From init method: Say hello bean!";
    }
    @Override
    public void destroy() {
        message = null;
        System.out.println("Message is null");
    }
    public HelloClazz(int person){
        message = "From COnstructor: Say Hello to "+person+" person(s)!";
    }

    public HelloClazz(HelloClazz clazz) {
        this.message = clazz.message;
    }
}
