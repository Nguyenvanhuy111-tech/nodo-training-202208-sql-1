package Unit7.NIO;

import java.nio.file.*;
import java.util.regex.Matcher;

public class FileFinderExample {
    class Finder extends SimpleFileVisitor{
       PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");
//       public FileVisitResult visitResult(){
//           if (matcher.matches())
//        }
    }
}
