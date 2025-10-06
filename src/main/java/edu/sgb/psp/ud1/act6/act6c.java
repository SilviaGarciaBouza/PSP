package edu.sgb.psp.ud1.act6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class act6c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;

        //Realiza un programa Java que solicite a un usuario el nombre de un proceso
        // que quiere buscar. El usuario introducirá una palabra contenida en el proceso,
        // por ejemplo para buscar todos los procesos de chrome podría escribir “chro”.
        System.out.println("Escribe el nombre d eun proceso que quieras buscar: ");
        word = sc.nextLine().toLowerCase().trim();
        try {
            ProcessBuilder pb = new ProcessBuilder("tasklist");
            Process process = pb.start();
            //El programa mostrará por pantalla todos los procesos que contengan la palabra introducida por
            // el usuario.
            getProcessOutputLines(process).filter(e->e.toLowerCase().contains(word)).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static Stream<String> getProcessOutputLines(Process p)throws IOException {

                    BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream()));
                    return br.lines();




        }



}
