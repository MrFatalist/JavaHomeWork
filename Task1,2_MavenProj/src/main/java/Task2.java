import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;
import ru.pflb.mq.dummy.interfaces.Connection;
import ru.pflb.mq.dummy.interfaces.Destination;
import ru.pflb.mq.dummy.interfaces.Producer;
import ru.pflb.mq.dummy.interfaces.Session;

public class Task2 {
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException, IOException {
        Path path = Path.of(args[0]);
        String tmp;
        Connection connection = new ConnectionImpl();
        connection.start();

        Session session = new SessionImpl();
        Destination destination = new DestinationImpl("MyQueue");
        Producer producer = new ProducerImpl(destination);

        while(flag) {
            try (Scanner sc = new Scanner(path)) {
                while (sc.hasNext()) {
                    tmp = sc.nextLine();
                    producer.send(tmp);
                    Thread.sleep(1000);
                }
            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }finally {
                session.close();
            }
        }
    }
}

