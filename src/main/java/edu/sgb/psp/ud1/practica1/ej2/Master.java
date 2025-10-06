package edu.sgb.psp.ud1.practica1.ej2;

import java.util.Scanner;

public class Master {

    //La ruta de un archivo de texto a analizar
    //1- Solicitar al usuario la ruta del archivo de texto a analizar.
    //2- Solicitar al usuario el número de procesos (N) en los que se quiere dividir el trabajo.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path;
        int n;
        System.out.println("Escribe la ruta del archivo de texto a analizar: ");
        path = sc.nextLine();
        System.out.println("Escribe el número de procesos (N) en los que se quiere dividir el trabajo: ");
        n = sc.nextInt();


        //3- Dividir el archivo en N bloques de líneas (los bloques deben repartirse de forma equilibrada).

    }
    //4- Lanzar N procesos Worker, pasando como argumentos:
    //La ruta del archivo de texto.
    //El rango de líneas (inicio y fin) de su bloque.
    //La ruta de un archivo temporal de salida.
    //5- Esperar a que todos los procesos Worker terminen.
    //6- Unir los archivos temporales de salida en un único archivo de salida.
    //7- Mostrar por pantalla el contenido del archivo de salida.
}
