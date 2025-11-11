package practicas.tema2.e02;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class PingTask implements Runnable{
    String ip;
    int nm;
    String name;

    public PingTask(String ip, int nm, String name) {
        this.ip = ip;
        this.nm = nm;
        this.name = name;
    }



    @Override
    public void run() {
        ProcessBuilder pb= new ProcessBuilder("ping", "-n", Integer.toString(nm), name);
        Instant start= Instant.now();
        Process pr= null;
        try {
            pr = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            int exitcode= pr.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Instant end= Instant.now();
        Duration d = Duration.between(start, end);
    }
}
