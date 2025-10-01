package edu.sgb.psp.ud1.act6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class act6b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Escribe el nombre del proceso: ");
            String comand = sc.nextLine();
            // TODO: Crea el proceso para ejecutar "tasklist" y lánzalo

            ProcessBuilder pb = new ProcessBuilder("tasklist", "/v" );
            // pb.inheritIO();
            Instant start= Instant.now();
            Process process= pb.start();
            // Captura y guarda la salida del comando "tasklist" en una List
            List<String> outputLines = getProcessOutputLines(process);
            outputLines.stream().filter(e->e.contains(comand)).forEach(e-> System.out.println(e));

            // TODO: Muestra solo que se desea mostrar (aplicando el filtro)
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
        try(
                BufferedReader br= new BufferedReader(process.inputReader())
        ){return br.lines().toList();

        }catch(Exception e){
            System.out.println(e.getMessage());
            return List.of();
        }
    }
}
