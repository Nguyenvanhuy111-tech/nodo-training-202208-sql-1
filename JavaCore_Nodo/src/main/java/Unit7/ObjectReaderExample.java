package Unit7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectReaderExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        File folder= new File("/media/mp/DATA/OneDrive/test1/");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File(folder,"my_object")));

        Object obj = input.readObject();
        Method method = obj.getClass().getMethod("run",new Class[0]);
        method.invoke(obj,new Object[0]);
//        input.close();
    }
}
