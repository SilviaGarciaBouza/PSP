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
        //1.Haz que el valor de la IP sea leída por teclado (clase Scanner)
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce la ip");
        String ip=sc.nextLine();
       try{
           ProcessBuilder pb= new ProcessBuilder("ping", ip, "-n","1");
           //2. Investiga los métodos disponibles en la API de ProcessBuilder
           //y haz que se vuelque la salida estándar a un fichero llamado
           // ping_std_output.txt y la salida de error a ping_error_output.txt
           //se puede usar // pb.inheritIO(); y lo envia por pantalla en lugar de lo sig
           pb.redirectOutput(new File("ping_std_output.txt"));
           pb.redirectError(new File("ping_error_output.txt"));
           System.out.println("ESTADO LISTO (READY)");
           //3.Medir cuánto tarda el proceso externo y, si se pasa de un
           // tiempo máximo (timeout), terminarlo forzosamente.
           // Investiga la clase Process para ver como esperar un timeout
           // y como forzar un cierre del proceso.
           Instant start= Instant.now();
           Process process= pb.start();
           System.out.println("ESTADO EN EJECUCIÓN (RUNNING)");
           boolean exitCode= process.waitFor(5, TimeUnit.SECONDS);
           if (!exitCode){
               process.destroyForcibly();
               System.out.println("ESTADO TERMINADO (TERMINATED) FORZADAMENTE");
           }
           Instant end= Instant.now();
           Duration diff= Duration.between(start, end);
           System.out.println("Tiempo de ejecución: " + diff.toMillis());
           //4.Lanza dos procesos de ping independientes
           // y comprueba cuando acaba cada un.
           ProcessBuilder pb2= new ProcessBuilder("ping", ip, "-n","10000");
           ProcessBuilder pb3= new ProcessBuilder("ping", ip, "-n","1");
           pb2.redirectOutput(new File("ping_std_output.txt"));
           pb2.redirectError(new File("ping_error_output.txt"));
           pb3.redirectOutput(new File("ping_std_output.txt"));
           pb3.redirectError(new File("ping_error_output.txt"));
           System.out.println("Proceso 2: ESTADO LISTO (READY)");
           System.out.println("Proceso 3: ESTADO LISTO (READY)");
           Instant start2= Instant.now();
           Process process2= pb.start();
           System.out.println("Proceso 2:ESTADO EN EJECUCIÓN (RUNNING)");
           boolean exitCode2= process.waitFor(5, TimeUnit.SECONDS);
           if (!exitCode2){
               process2.destroyForcibly();
               System.out.println("Proceso 2: ESTADO TERMINADO (TERMINATED) FORZADAMENTE");
           }
           Instant end2= Instant.now();
           Duration diff2= Duration.between(start2, end2);
           System.out.println("Tiempo de ejecución del proceso 2: " + diff.toMillis());
           Instant start3= Instant.now();
           Process process3= pb3.start();
           System.out.println("Proceso 3: ESTADO EN EJECUCIÓN (RUNNING)");
           boolean exitCode3= process.waitFor(5, TimeUnit.SECONDS);
           if (!exitCode3){
               process3.destroyForcibly();
               System.out.println("Proceso 3: ESTADO TERMINADO (TERMINATED) FORZADAMENTE");
           }
           Instant end3= Instant.now();
           Duration diff3= Duration.between(start3, end3);
           System.out.println("Proceso 3: Tiempo de ejecución: " + diff.toMillis());
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
