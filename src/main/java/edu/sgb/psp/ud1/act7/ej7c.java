package edu.sgb.psp.ud1.act7;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class ej7c {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try {

            ProcessBuilder pb = new ProcessBuilder("echo","hola");
            Process p = pb.start();
            p.waitFor();

            pb.command().clear();
            pb.command("cmd","/c","dir");

            pb.directory(new File("newDirectory"));

            pb.command("find");
            pb.command().add("\"*txt\"");

            System.out.println("Que quieres filtrar?");
            String filt= sc.nextLine();
            Map<String, String> SEARCH_QUERY = pb.environment();
            SEARCH_QUERY.put("SEARCH", filt);

            pb.command().clear();
            pb.command("cmd","/c");
            pb.command().add("dir  *.txt | findstr /I \"%SEARCH%\"");


            p.waitFor();



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
