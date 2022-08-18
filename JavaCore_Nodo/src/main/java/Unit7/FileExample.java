package Unit7;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FileExample {
    static File file = new File("/media/mp/DATA/OneDrive/desktop.ini");

//    public static void main(String[] args) {
////      checkFile();
//        getSize(file);
//        System.out.println("Size: " + getSize(file) / (1024 * 1024) + " MB");
//    }

    public static void checkFile() {
        if (file.isDirectory()) {
            System.out.println("THis is folder");
        } else {
            System.out.println("This is file");
        }

//        System.out.println("This is "+(file.isFile()?"FIle":"FOlder"));
//
//        List<File> files = new ArrayList<>();
//        for (File f: files
//             ) {
//            System.out.println(f.getName());
//        }
    }

    public static long getSize(File file) {
        if (file.isFile()) return file.length();
        File[] files = file.listFiles();
        int length = 0;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                length += getSize(files[i]);
                continue;
            }
            length += files[i].length();
        }
        return length;
    }

}