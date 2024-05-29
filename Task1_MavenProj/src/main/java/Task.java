import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.implementation.DestinationImpl;
import ru.pflb.mq.dummy.implementation.ProducerImpl;
import ru.pflb.mq.dummy.implementation.SessionImpl;
import ru.pflb.mq.dummy.interfaces.Connection;
import ru.pflb.mq.dummy.interfaces.Destination;
import ru.pflb.mq.dummy.interfaces.Producer;
import ru.pflb.mq.dummy.interfaces.Session;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        String[] messages = new String[] {"One", "Two", "Three", "Four", "Five", "Six"};
        Connection connection = new ConnectionImpl();
        connection.start();

        Session session = new SessionImpl();
        Destination destination = new DestinationImpl("MyQueue");
        Producer producer = new ProducerImpl(destination);


        for(String message: messages){
            producer.send(message);
            Thread.sleep(2000);
        }

        session.close();
    }
}

