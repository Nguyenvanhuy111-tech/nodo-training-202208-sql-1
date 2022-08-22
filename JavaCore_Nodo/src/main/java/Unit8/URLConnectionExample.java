package Unit8;

import com.sun.jdi.connect.spi.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class URLConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://www.google.com.vn/");
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();

        int read;
        byte[] bytes = new byte[110];
        while ((read= stream.read(bytes)) !=-1){
            System.out.println(new String(bytes,0,read));
        }

    }
}
