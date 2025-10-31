package edu.sgb.psp.practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Fusioner {
    public static void main(String[] args) {
        if (args.length ==0 ) {
            System.err.println("Error: fusioner no tiene argumentos. Necesita los archivos temporales donde leer para hcer el calculo");
        } else {
            String[] tempFiles =args;
            Map<String, Integer> totalFrecuencies;
            try {
                // 1 y 2- Lee y suma las frecuencias de todos los archivos
                totalFrecuencies = readAndSumFrec(tempFiles);
                // 3- Imprime el Top 5 en la salida estándar
                printTopFrecuencias(totalFrecuencies);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            } finally {
                deleteTemporaryFiles(tempFiles);
            }
        }
    }

    //1-Lee todos los archivos temporales.
    //2-Suma las frecuencias de cada palabra
    private static Map<String, Integer> readAndSumFrec(String[] filePaths) throws IOException {
        Map<String, Integer> totalFrecuencies = new HashMap<>();
        for (String element : filePaths) {

            try (BufferedReader br = new BufferedReader(new FileReader(new File(element)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        String[] eParts = line.split(",");
                        if (eParts.length < 2) {
                            System.err.println("Error: la linea no tiene las dos partes");
                        } else {
                            String word = eParts[0].trim();
                            int frequency = Integer.parseInt(eParts[1].trim());
                            totalFrecuencies.put(word, totalFrecuencies.getOrDefault(word, 0) + frequency);
                        }
                    } catch (NumberFormatException ex) {
                        System.err.println( ex.getMessage());
                    }
                }
            } catch (IOException e) {
                System.err.println( e.getMessage());
                throw e;
            }
        }
        return totalFrecuencies;
    }


    //3-Imprime el Top 5 en su salida estándar
    private static void printTopFrecuencias(Map<String, Integer> globalMap) {
        int[] count = {1};
        System.out.println("Top 5 palabras más frecuentes:");
        globalMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> {

                    System.out.println(count[0]++ + ". " + entry.getKey() + " : " + entry.getValue());

                });
    }

    private static void deleteTemporaryFiles(String[] filePaths) {
        for (String element : filePaths) {
            File tempFile = new File(element);
            if (tempFile.exists()) {
                tempFile.delete();
                }
            }
        }
    }

