package edu.sgb.psp.ud1.act8b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Master {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String word = "";
            List<String> arrayWords = new ArrayList<String>();
            do {
                System.out.println("Escribe numeros hasta que pares e introduzcas la palabra FIN : ");
                word = sc.nextLine();
                if (word.matches("[0-9]+")) {
                    arrayWords.add(word);

                }
            } while (!word.toLowerCase().trim().equals("fin"));

            String classpathdelproyect = System.getProperty("java.class.path");
            List<String> command = new ArrayList<>();
            command.add("java");
            command.add("-cp");
            command.add(classpathdelproyect);
            command.add("edu.sgb.psp.ud1.act8b.Subordinate");

            command.addAll(arrayWords);

            ProcessBuilder pb = new ProcessBuilder(command);
            pb.inheritIO();
            Process p = pb.start();
            try(BufferedReader br= new BufferedReader(new InputStreamReader(p.getInputStream())))
            {
                br.lines().forEach(System.out::println);
            }
            p.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
