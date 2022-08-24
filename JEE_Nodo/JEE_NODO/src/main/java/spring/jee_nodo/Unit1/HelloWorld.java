package spring.jee_nodo.Unit1;

import org.apache.log4j.Logger;

public class HelloWorld {
    private final static Logger LOGGER =Logger.getLogger(HelloWorld.class);
    private String message;

    public void sayHello(){
        LOGGER.info("From HelloWorld "+message);
    }
}
