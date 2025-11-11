package ejercicios;
import java.io.IOException;
public class E01 {



        public static void main(String[] args) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("ls");
                Process process = processBuilder.start();
                System.out.println("Proceso iniciado: " + process.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Proceso iniciado: Process[pid=5384, exitValue=0] 0 es sin errores

}
