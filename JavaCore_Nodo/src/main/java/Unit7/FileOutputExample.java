package Unit7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
//        File file = new File("/media/mp/DATA"+File.separator+"OneDrive"+File.separator+"hanoijava.txt");
//        FileOutputStream fileOutputStream=null;
//        try {
//            fileOutputStream=new FileOutputStream(file);
//            String bytes = "Hello Ha noi Java Class";
//            fileOutputStream.write(bytes.getBytes());
//        }finally {
//            if (fileOutputStream!=null){
//                fileOutputStream.close();
//            }
//        }
//---------------------------------------------------------------------
        File file = new File("/media/mp/DATA/OneDrive/hanoijava.txt");

//            try (FileInputStream inputStream = new FileInputStream(file)){
//                byte bytes[] = new byte[16];
//                inputStream.read(bytes);
//                System.out.println(new String(bytes));
//            }
//-----------------------------------------------------------------------------
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte bytes[] = new byte[4 * 1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = inputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, read));
            }

            System.out.println("[" + builder + "]");

        }
    }

}
