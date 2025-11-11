package ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E03  {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Dame la ruta: ");
        String path= new Scanner(System.in).nextLine().trim();
        if(!new File(path).isDirectory()){
            System.out.println("no es un directorio");
            return;
        }
        ProcessBuilder pb= new ProcessBuilder("ls", path);
        pb.inheritIO();
        Process p=pb.start();
        int exitCode= p.waitFor();

        pb.command().remove(path);
        pb.command().add("users.txt");
        pb.inheritIO();
        Process p2= pb.start();
        int exitCode2= p.waitFor();




    }
}
