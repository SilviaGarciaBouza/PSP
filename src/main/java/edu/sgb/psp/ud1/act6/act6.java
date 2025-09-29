package edu.sgb.psp.ud1.act6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Realiza un programa Java que solicite a un usuario el nombre de un proceso que quiere buscar.
* El usuario introducirá una palabra contenida en el proceso, por ejemplo para buscar todos
* los procesos de chrome podría escribir “chro”.

El programa mostrará por pantalla todos los procesos que contengan la palabra introducida por el usuario.
* */
public class act6 {

    public static void main(String[] args) {
        //pido el nombre del proceso que quiero buscar
        Scanner sc= new Scanner(System.in);
        System.out.println("Escribe el nombre del proceso que quieres buscar: ");
        String proceso= sc.nextLine();

        try {
            //creo el proceso
          ProcessBuilder pb= new ProcessBuilder("tasklist");
          Process process= pb.start();
            // Captura y guarda la salida del comando "tasklist" en una List
            List<String> outputLines = getProcessOutputLines(process);

            //  Muestra solo que se desea mostrar (aplicando el filtro)
            outputLines.stream().filter(e-> e.contains(proceso)).forEach(e-> System.out.println(e));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Recoger la informacion de salida del proceso y guardarla en una lista de String
     *
     * @param process
     * @return
     * @throws IOException
     */
    private static List<String> getProcessOutputLines(Process process) throws IOException {
        List<String> outputStrings= new ArrayList<>();
        try(    InputStreamReader isr= new InputStreamReader(process.getInputStream());
                BufferedReader br= new BufferedReader(isr)
                ) {
        String line;
        while((line=br.readLine())!=null){
            outputStrings.add(line);
        }
        }
        return outputStrings;

    }
    }

