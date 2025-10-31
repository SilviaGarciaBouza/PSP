package edu.sgb.psp.practica1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SearchAndDestroy {

    //TODO: cambiafr Calculator app por calc???

    public static void main(String[] args) {
        System.out.println("Procesos activos");
        getAllProcess();
        System.out.println("---------------------------------------------");
        System.out.println("Procesos notepad.exa y CalculatorApp.exe");
        if (getRunningProcess(getFilterProcess("notepad.exe")).anyMatch(e -> true)) {
            System.out.println("Proceso encontrado: notepad.exe");
            killRunningProcess("notepad.exe");

        } else {
            System.out.println("No se encontraron instancias de notepad.exe");
        }
        if (getRunningProcess(getFilterProcess("CalculatorApp.exe")).anyMatch(e -> true)) {
            System.out.println("Proceso encontrado: CalculatorApp.exe");
            killRunningProcess("CalculatorApp.exe");
        } else {
            System.out.println("No se encontraron instancias de CalculatorApp.exe");

        }
        System.out.println("---------------------------------------------");
    }

    //1- El programa debe ser capaz de listar los procesos activos del sistema operativo.
    static public void getAllProcess(){
        ProcessBuilder pb= new ProcessBuilder("tasklist");
        pb.inheritIO();
        try {
            Process process= pb.start();
            process.waitFor();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
    //2- Debe buscar los procesos que correspondan a las aplicaciones Notepad y Calculadora .
    //Si se encuentra un proceso de Notepad o CalculatorAppuladora, el programa deberá informar al usuario que ha encontrado dicho proceso
    static public Stream<String> getFilterProcess(String name)  {
        ProcessBuilder pb= new ProcessBuilder("tasklist","/v","/fi","\"imagename eq "+name+"\"");
        try {
            Process p = pb.start();
            p.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            return br.lines();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        return Stream.empty();
    }
    //3- Procesos que se estén ejecutando usando la salida de  getFilterProcess
    static public Stream<String> getRunningProcess(Stream<String> filteredProcess){
        return filteredProcess.filter(e->e.toLowerCase().contains("running"));
    }
    //4- Si alguno de estos procesos está en ejecución, el programa deberá forzar su cierre.
    static public void killRunningProcess(String name){

        ProcessBuilder pb= new ProcessBuilder("taskkill","/f","/im",name);
        try {
            Process process= pb.start();
            process.waitFor();
            System.out.println("Proceso "+name+" ha sido terminado.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}