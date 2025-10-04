package edu.sgb.psp.ud1.act2;
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class act2b {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String ip;

            //Haz que el valor de la IP sea leída por teclado (clase Scanner)
            System.out.println("Escribe la ip: ");
             ip= sc.nextLine().trim();
             try {
                 ProcessBuilder pb = new ProcessBuilder("ping", "-n","1", ip);
                 //Investiga los métodos disponibles en la API de ProcessBuilder  y
                 // haz que se vuelque la salida estándar a un fichero llamado
                 // ping_std_output.txt y la salida de error a ping_error_output.txt
                 //pb.inheritIO(); lo mostra por pantalla
                 pb.redirectOutput(new File("ping_std_output.txt"));
                 pb.redirectError(new File("ping_error_output.txt"));
                 //Medir cuánto tarda el proceso externo y, si se pasa de un tiempo
                 // máximo (timeout), terminarlo forzosamente. Investiga la
                 // claseProcess para ver como esperar un timeout y como forzar
                 // cierre del proceso.
                 Process p = pb.start();
                 Instant start= Instant.now();
                 boolean isfinished=p.waitFor(5, TimeUnit.SECONDS);
                 if(!isfinished){
                     p.destroyForcibly();
                 }
                 Instant end= Instant.now();
                 Duration duration= Duration.between(start, end);
                 int exitCode = p.exitValue();
                 System.out.println("Código de salida del proceso: " + exitCode);
                 System.out.println("Tiempo de ejecución: " + duration.toMillis());

             } catch (Exception e) {
                 e.printStackTrace();
             }
             //Lanza dos procesos de ping independientes y comprueba cuando acaba cada un.
            try {
                ProcessBuilder pb2 = new ProcessBuilder("ping", "-n", "2", ip);
                ProcessBuilder pb3 = new ProcessBuilder("ping", "-n", "200", ip);

                pb2.redirectOutput(new File("file.txt"));
                pb2.redirectError(new File("error.txt"));
                pb3.redirectOutput(new File("filep.txt"));
                pb3.redirectError(new File("errorp.txt"));

                Process p2= pb2.start();
                Process p3= pb3.start();
                execute(p2,5);
                execute(p3,5);


            }catch (Exception e){
                e.printStackTrace();
            }

        }
        private static void execute(Process p, long time){
            try{
            Instant start3= Instant.now();
            boolean isfinished3= p.waitFor(time, TimeUnit.SECONDS);
            if(!isfinished3){
                p.destroyForcibly();
            }
            Instant end3= Instant.now();
            Duration duration3= Duration.between(start3, end3);
            int exitCode3 = p.exitValue();
            System.out.println("Código de salida del proceso: " + exitCode3);
            System.out.println("Tiempo de ejecución: " + duration3.toMillis());}
catch(Exception e){

}
        }
    }


