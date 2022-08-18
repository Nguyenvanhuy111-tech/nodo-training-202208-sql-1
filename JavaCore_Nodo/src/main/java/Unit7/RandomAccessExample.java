package Unit7;

import java.awt.*;
import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessExample {
    public static void main(String[] args) throws Exception {
        File file = new File("/media/mp/DATA/OneDrive/hanoijava.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile (file,"rw")){
            randomAccessFile.seek(9);
            byte[] bytes = new byte[4*102];
            int read = randomAccessFile.read(bytes);
            System.out.println(new String(bytes,0,read,"utf8"));

            randomAccessFile.seek(file.length());
            randomAccessFile.write("\r\n".getBytes());
            randomAccessFile.writeChars("Hello co can");

            Desktop.getDesktop().open(file);
        }
    }
}
