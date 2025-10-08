package edu.sgb.psp.ud1.practica1.ej2;

import java.util.HashMap;
import java.util.Map;

public class Worker {
    public static void main(String[] args) {

        if(args.length != 3){
            System.out.println("Error: El Worker debe recibir 4 argumentos");
            return;
        }
        String inputFilePath= args[0];
        int startLine= Integer.parseInt(args[1]);
        int endLine= Integer.parseInt(args[2]);
        String outputFilePath= args[3];

        //1-Lee únicamente su rango de líneas
        Map<String, Integer> wordCount= new HashMap<>();

        //2- Calcula la frecuencia de cada palabra en su bloque.


        //3- Guarda el resultado en un archivo temporal en el siguiente formato (una línea por palabra):
    }


}



