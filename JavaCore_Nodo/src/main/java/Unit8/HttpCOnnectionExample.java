package Unit8;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HttpCOnnectionExample {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://www.google.com.vn/");
        URLConnection connection = url.openConnection();

        Path path= Paths.get("test.html");
        try (InputStream inputStream = connection.getInputStream();
             OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND)
        ){
            int read;
            byte[] bytes = new byte[1000];
            while ((read = inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,read);
            }
        }finally {
            Desktop.getDesktop().open(path.toFile());
        }
    }
}
