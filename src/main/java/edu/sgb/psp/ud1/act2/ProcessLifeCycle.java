package edu.sgb.psp.ud1.act2;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.time.Instant.now;

public class ProcessLifeCycle {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try {
            //IMPORTANTE: Primero empezar uno y terminarlo y despues empezar y terminar el segundo
            // NEW: construimos el proceso
            System.out.println("Estado: NUEVO (NEW)");
            System.out.println("Escribe la ip: ");
            String ip= sc.nextLine();

            ProcessBuilder pb = new ProcessBuilder("ping",ip, "-n","100000");
            ProcessBuilder pb2 = new ProcessBuilder("ping",ip, "-n", "1");

           // pb.inheritIO();
            pb2.inheritIO();
            pb.inheritIO();


            /*si se haqce el inerit es que lo escribe en el log y sino en elarchivo asi q o se hace uno oo el otro
            pb.redirectError(new File("ping_error_output.txt"));
            pb.redirectOutput(new File("ping_std_output.txt"));
            System.out.println("Estado: LISTO (READY)");
            pb2.redirectError(new File("ping_error_output.txt"));
            pb2.redirectOutput(new File("ping_std_output.txt"));
            System.out.println("Estado: LISTO el Proceso2 (READY)");
*/

            Instant start= Instant.now();
            Process p = pb.start();
            boolean exitCode= p.waitFor(5, TimeUnit.SECONDS);

            if(!exitCode)
            {
                System.out.println("El proceso ha superado el tiempo, procedera a destruirse");
                p.destroyForcibly();

            }
            Instant end= Instant.now();

            Instant start2= Instant.now();
            Process p2 = pb2.start();



            boolean exitCode2= p2.waitFor(5, TimeUnit.SECONDS);

            if(!exitCode2)
            {
                System.out.println("El proceso ha superado el tiempo, procedera a destruirse");
                p2.destroyForcibly();

            }
            Instant end2= Instant.now();

          Duration diff= Duration.between(end,start);
          Duration diff2= Duration.between(end2,start2);

            System.out.println("Estado: EN EJECUCIÓN (RUNNING)");
           // System.out.println(p.info().totalCpuDuration());
            System.out.println("La duracion del primer proceso es: "+diff+(exitCode?"El proceso terminó solo":"El proceso se destruyó al alcanzar el tiempo max"));

          //  System.out.println(p2.info().totalCpuDuration());
            System.out.println("La duracion del segundo proceso es: "+diff2+(exitCode2?"El proceso terminó solo":"El proceso se destruyó al alcanzar el tiempo max"));



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
