package edu.sgb.psp.ud1.act1;

import java.io.IOException;

public class MyFirstProcess {
    public static void main(String[] args) {
        try {
            //se crea el proceso
            //si no esta en la carpeta esa pues hay q poner todo su path , sino llega como en este ejemplo explorer.exe
            ProcessBuilder processBuilder = new ProcessBuilder("explorer.exe");
            Process process = processBuilder.start();
            System.out.println("Proceso iniciado: " + process.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

