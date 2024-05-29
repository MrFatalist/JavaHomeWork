import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task {
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException, IOException {
        Path path = Path.of(args[0]);
        String tmp;

        //KillListener listener = new KillListener(); // нерабочий прерыватель
        //listener.run();

        while(flag) {
            try (Scanner sc = new Scanner(path)) {
                while (sc.hasNext()) {
                    tmp = sc.nextLine();
                    System.out.println(tmp);
                    Thread.sleep(1000);
                }
            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }
        }
    //System.out.println("done!");
    }
}

