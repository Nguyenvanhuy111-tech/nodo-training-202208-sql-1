package Unit7.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
public class CopingAndMovingExample {
    public static void main(String[] args) throws IOException {
       Path source = Paths.get("/media/mp/DATA/OneDrive/hanoijava.txt");
        Path target = Paths.get("/media/mp/DATA/OneDrive2/hanoijava.txt");
        Files.copy(source,target,REPLACE_EXISTING);
    }
}
