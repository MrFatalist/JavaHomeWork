import java.util.Scanner;

public class KillListener extends Thread{
    public void run(){
        Scanner sc = new Scanner(System.in);
        String point = "";
            while (point != "q") {
                point = sc.nextLine();
            }
        Task.flag = false;
    }
}

