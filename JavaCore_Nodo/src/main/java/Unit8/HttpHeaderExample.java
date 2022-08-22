package Unit8;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HttpHeaderExample {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://www.google.com.vn/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println("Http method "+connection.getRequestMethod());

        Map<String, List<String>> headers = connection.getHeaderFields();
        BiConsumer<String,List<String>> header = (key,values)->{
            System.out.println("Key: "+key+" Values: "+values);
        };
        headers.forEach(header);
    }
}
