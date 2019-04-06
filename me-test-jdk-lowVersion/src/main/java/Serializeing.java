import java.io.*;
import java.time.LocalDateTime;

/**
 * @author zhaohaojie
 * @date 2019-03-20 11:31
 */
public class Serializeing {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSerialize serialize = new TestSerialize("我。",25, LocalDateTime.now());

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("d://test.txt"));
        outputStream.writeObject(serialize);
        outputStream.flush();
        outputStream.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("d://test.txt"));
        TestSerialize ins = (TestSerialize) in.readObject();
        System.out.println(ins.toString());
    }
}

