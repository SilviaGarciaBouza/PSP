package practicas.p01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

public class p01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //pedir por teclado el filtro
        Scanner sc= new Scanner(System.in);
        System.out.println("que aplicacio quieres buscar? ");
        String imagenameApp = sc.nextLine().trim().toLowerCase();
        //1- El programa debe ser capaz de listar los procesos activos del sistema operativo.

        ProcessBuilder pb = new ProcessBuilder("tasklist");
        pb.inheritIO(); //lo muestra por pantalla

        //redirige la salida a archivos: o se hereda o se redirig pero no las dos
       // pb.redirectOutput(new File("ficherosalida.txt"));
        //pb.redirectError(new File("ficheroerror.txt"));

        //modificar el filtro
        pb.command().add("/fi");
        pb.command().add("imagename eq " + imagenameApp + "*");
        //eliminar el filtro
        pb.command().remove("/fi");
        pb.command().removeAll(pb.command());
        pb.command("tasklist");


        Process p = pb.start();//ioexception
        p.waitFor();//interrupted
        //2- Debe buscar los procesos que correspondan a las aplicaciones Notepad y Calculadora .
        //Si se encuentra un proceso de Notepad o CalculatorAppuladora, el programa deberá informar al usuario que ha encontrado dicho proceso
        ProcessBuilder pb2= new ProcessBuilder("tasklist", "/fi", "imagename eq notepad.exe");
        Process p2= pb2.start();
        p2.waitFor();
        BufferedReader br= new BufferedReader(new InputStreamReader(p2.getInputStream()));
        Stream<String> linea = br.lines();
        br.close();
        if(linea.filter(e -> e.matches("notepad.exe")).toList().size() != 0){
            System.out.println("Se ha encontrado el proceso de Notepad");

            ProcessBuilder pb3 = new ProcessBuilder("taskkill","/f","/im","notepad.exe");
            Process p3= pb3.start();
            p3.waitFor();

        }





    }
}