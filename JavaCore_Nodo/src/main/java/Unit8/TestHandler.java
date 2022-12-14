package Unit8;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "<html><h2>THis is the response</h2></html>";

        exchange.sendResponseHeaders(200,message.length());
//        OutputStream out = exchange.getResponseBody();

        try  (OutputStream out = exchange.getResponseBody()){
            out.write(message.getBytes());
        }
    }
}
class HttpServerExample{
    public static void main(String[] args) throws IOException {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            HttpHandler testHandler = new TestHandler();
            server.createContext("/test",testHandler);
            server.setExecutor(Executors.newFixedThreadPool(5));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
