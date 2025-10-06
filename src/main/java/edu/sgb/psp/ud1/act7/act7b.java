package edu.sgb.psp.ud1.act7;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class act7b {


    static final ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "echo", "Hola");
static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        try {
            pb.inheritIO();
            System.out.println("Comando inicial: " + pb.command());
//
            //Modificar el comando a ejecutar en tiempo de ejecución para que  ejecute un listar
            //directorio en vez de hacer un echo "Hola" . Hacer uso de .command
            pb.command().removeAll(pb.command());
            pb.command("cmd", "/c", "dir");
//cambiar el directorio por otro:
            pb.directory(new File("directorioPath"));
            //que muestre solo los ficheros txt
            pb.command().add("find");
            pb.command().add("*.txt");

            //pideal usuario o q quiere que filtre
            System.out.println("Escribe lo que quieres a filtre: ");
            String filtro= sc.nextLine().trim();
            //guarda en vriable de entorno llamada SEARCH_QUERY
            Map<String, String> environment = pb.environment();
            environment.put("SEARCH_QUERY",filtro);
            pb.command().clear();
            pb.command("cmd","/c");
            pb.command().add("dir  *.txt | findstr /I \"%SEARCH_QUERY%\"");


            pb.start().waitFor();

            System.out.println("Directorio de trabajo: " + pb.directory());
            System.out.println("Comando final ejecutado: " + pb.command());

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

