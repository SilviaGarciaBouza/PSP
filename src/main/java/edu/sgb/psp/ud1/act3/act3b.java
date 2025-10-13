package edu.sgb.psp.ud1.act3;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class act3b {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String absolutelyPath;
        //Solicite al usuario la ruta absoluta de un directorio
        //del que quiere consultar su contenido. Ejemplo C:\Users
        System.out.println("Escribe una ruta absoluta de un directorio: ");
        absolutelyPath= sc.nextLine().trim();
        if(!(new File(absolutelyPath).isDirectory())){
            System.out.println("No es un directorio");
            return;
        }
        //Muestre el contenido de dicho directorio en la consola del IDE
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c", "dir", absolutelyPath);
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();

        }catch (Exception e){
        }





        //Haz ahora que muestre el contenido del directorio en un fichero llamado users.txt
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c", "dir", absolutelyPath);
            pb.redirectOutput(new File("users.txt"));
          //  pb.redirectError(new File("error.txt"));
            Process p = pb.start();
           p.waitFor();
            System.out.println("Código de salida: " );
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
