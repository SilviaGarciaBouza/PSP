package edu.sgb.psp.ud2.act2;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class PingTask implements Runnable{
    private String ip;
    private int numPAquetesEnviar;
    private String nameTarea;

    public PingTask(String ip, int numPAquetesEnviar, String nameTarea) {
        this.ip = ip;
        this.numPAquetesEnviar = numPAquetesEnviar;
        this.nameTarea = nameTarea;
    }
//salida esperada:[Task1] Starting ping to 8.8.8.8 with 3 packets...
//[Task2] Starting ping to 8.8.8.8 with 8 packets...
//[Task1] Finished in 3047 ms.
//[Task2] Finished in 8010 ms.
    @Override
    public void run() {
        ProcessBuilder pb = new ProcessBuilder("ping", "-n", Integer.toString(numPAquetesEnviar), ip);
        try {
            Process p=pb.start();
            Instant start= Instant.now();
            System.out.println("["+nameTarea+"] Starting ping to "+ip+" with "+numPAquetesEnviar+" packets...");
            p.waitFor();
            Instant end= Instant.now();
            Duration duration= Duration.between(start,end);
            System.out.println("["+nameTarea+"] Finished in "+duration.toMillis()+" ms.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
