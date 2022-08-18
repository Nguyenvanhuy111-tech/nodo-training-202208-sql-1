package Unit7;

import java.io.*;

public class PrintMessage implements Runnable, Serializable {
    public PrintMessage(String can_noi_nOi) {
    }

    @Override
    public void run() {

    }
}
class ObjectWriterExample{
    public static void main(String[] args) throws IOException {
        File folder= new File("/media/mp/DATA/OneDrive/test1/");
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = new FileOutputStream(new File(folder,"my_object"));
        objectOutputStream = new ObjectOutputStream(fileOutputStream);

//        PrintMessage printMessage =new PrintMessage();

        objectOutputStream.writeObject(new PrintMessage("Can Noi NOi"));

    }
}
