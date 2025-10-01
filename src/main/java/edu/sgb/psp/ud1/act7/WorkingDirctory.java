package edu.sgb.psp.ud1.act7;

import java.io.*;
import java.util.*;

public class WorkingDirctory {
    static final ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "echo", "Hola");

    public static void main(String[] args) {
        try {

            pb.inheritIO();

            System.out.println("Comando inicial: " + pb.command());


            //1.Modificar el comando a ejecutar en tiempo de ejecución para que  ejecute un
            // listar directorio en vez de hacer un echo "Hola" . Hacer uso de .command
            pb.command().removeAll(pb.command());
                    pb.command().add("cmd");
                    pb.command().add("/c");
                    pb.command().add("dir");
                    //2.Cambia el working directory del proceso por otro cualquiera.
            // Hacer uso de .directory.
            pb.directory(new File(System.getProperty("user.home")));

            //Modifica el comando del proceso para que muestre solo los ficheros .txt  en ese directorio.
            //El comando para buscar en windows es find y puedes utilizar la comunicación entre procesos
            // para pasarle el resultado del listado.
            pb.command().add("\"*.txt\"");

            //Pide al usuario que introduzca por pantalla lo que quiera filtrar del directorio y
            // guardalo en una variables de entorno llamada SEARCH_QUERY .
            // Modifica el commando para que utilice la variable de entorno.
            // Obtiene el entorno del proceso. Se puede leer, modificar, eliminar...
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce lo que quieres q filtre del fichero: ");

            String filtro= sc.nextLine();
            Map<String, String> environment = pb.environment();
            environment.put("SEARCH_QUERY",filtro);
            pb.command().add("|");
            pb.command().add("find");

            pb.command().add("\""+environment.get("SEARCH_QUERY")+"\"");





            pb.start().waitFor();

            System.out.println("Directorio de trabajo: " + pb.directory());
            System.out.println("Comando final ejecutado: " + pb.command());

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
