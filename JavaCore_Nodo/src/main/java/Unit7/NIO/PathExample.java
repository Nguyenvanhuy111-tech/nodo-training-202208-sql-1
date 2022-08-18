package Unit7.NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class PathExample {
//    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("/media/mp/DATA/OneDrive");
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return entry.isAbsolute();
//            }
//        };
//        System.out.println("THis is " + (Files.isDirectory(path) ? "folder" : "file") + "!");
//        System.out.println(Files.exists(path));
//
//
//        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, filter)) {
//            for (Path p : directoryStream
//            ) {
//                System.out.println(p.getFileName());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public static void main(String[] args) {
        Path path= Paths.get("/media/mp/DATA/OneDrive");
        Path path2= path.resolve("hanoijava.txt");


        Charset charset = Charset.forName("utf-8");

        try  (BufferedReader reader =Files.newBufferedReader(path2,charset)){
            String line = null;
            while ((line= reader.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
