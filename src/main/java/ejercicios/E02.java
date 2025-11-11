package ejercicios;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class E02 {
    public void main() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la ip: ");
        String myIp = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("ping", "-n", "1", myIp);
        pb.redirectOutput(new File("output.txt"));
        pb.redirectError(new File("error.txt"));
        Instant start = Instant.now();
        Process p= pb.start();

        if(!p.waitFor(5, TimeUnit.SECONDS)){
            p.destroyForcibly();

        }
        Instant end= Instant.now();
        Duration d= Duration.between(start,end);

        ProcessBuilder pb1 = new ProcessBuilder("","");
        ProcessBuilder pb2 = new ProcessBuilder("","");

         Instant start2= Instant.now();
         Process p1=pb1.start();
        Process p2= pb2.start();

        boolean pifinish= false;
        boolean p2finish= false;

         while (!pifinish && !p2finish){
             if(!pifinish && p1.isAlive()){
                 pifinish = true;
                 Instant end1= Instant.now();
                 Duration d1= Duration.between(start2,end1);
                 System.out.println(p1.exitValue());
             }
             if(!p2finish&& !p2.isAlive()){
                 p2finish=true;
                 Instant end2= Instant.now();
                 Duration d2= Duration.between(start2,end2);
                 System.out.println(p2.exitValue());
             }
         }


    }

}
