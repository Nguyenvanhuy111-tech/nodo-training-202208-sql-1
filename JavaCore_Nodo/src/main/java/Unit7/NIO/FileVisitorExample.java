package Unit7.NIO;

import java.io.File;
import java.nio.file.*;

public class FileVisitorExample {
    public static class PrintFile extends SimpleFileVisitor<Path>{
        public FileVisitResult visitFile(){
            System.out.println(Paths.get("/media/mp/DATA/OneDrive").isAbsolute());
        return FileVisitResult.CONTINUE;
        }

//        public FileVisitResult postVisitDirectory(){
//            System.out.println(Paths.get("/media/mp/DATA/OneDrive").isAbsolute());
//            return
//        }
    }
}
