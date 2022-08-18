package Unit7.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        Path path= Paths.get("/media/mp/DATA/OneDrive/hanoijava.txt");
        ByteBuffer buffer = ByteBuffer.allocate(14);
        try (FileChannel fc = FileChannel.open(path, StandardOpenOption.READ,StandardOpenOption.WRITE)){
            fc.read(buffer);
            System.out.println(new String(buffer.array()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
