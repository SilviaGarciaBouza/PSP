package edu.sgb.psp.ud1.act8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Master {
   static public Scanner sc= new Scanner(System.in);
   public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List<String> listaNumeros = new ArrayList<>();
        String number="start";
        while (!number.equals("fin")) {
            System.out.println("Escribe un numero: (fin para terminar)");

            number=sc.nextLine();
            if(!number.equals("fin")){
            listaNumeros.add(number);}
        }



        try{
            String classpath = System.getProperty("java.class.path");
            List<String> command = new ArrayList<>();
            command.add("java");
            command.add("-cp");
            command.add(classpath);
            command.add("edu.sgb.psp.ud1.act8.Subordinate");
            command.addAll(listaNumeros);

            ProcessBuilder pb= new ProcessBuilder(command);
            Process subordinate= pb.start();

            try (BufferedReader br =
                         new BufferedReader(new InputStreamReader(subordinate.getInputStream()))) {
                String salida = br.readLine();
                System.out.println(salida);
            }




            } catch (IOException e) {
            throw new RuntimeException(e);
        }

   }
}
