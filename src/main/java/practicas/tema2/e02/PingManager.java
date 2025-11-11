package practicas.tema2.e02;

import java.io.IOException;

public class PingManager {
    public static void main(String[] args) throws IOException, InterruptedException {
        PingTask p1= new PingTask("000000",1, "cal.exe");
        PingTask p2= new PingTask("000000",1, "cal.exe");

        Thread ti= new Thread(p1);
        Thread t2= new Thread(p2);

        ti.start();
        t2.start();
        ti.join();
        t2.join();

    }
}
