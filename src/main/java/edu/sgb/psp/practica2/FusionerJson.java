package edu.sgb.psp.practica2;

import java.io.*;
import java.util.*;

public class FusionerJson {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Error: fusionerJson no tiene argumentos. Necesitam la ruta para escribir el json y los archivos temporales donde leer para hcer el calculo");
        } else {
            String jsonOutputPath = args[0];
            String[] tempFiles = new String[args.length - 1];
            for (int i = 0; i < tempFiles.length; i++) {
                tempFiles[i] = args[i + 1];
            }
            Map<String, Integer> totalFrecuencies;
            try {
                //1. Lee y suma las frecuencias de todos los archivos
                totalFrecuencies = readAndSumFrec(tempFiles);
                // 2. Escribe el Top 5 en el fichero JSON
                writeTopFrecuenciasToJson(totalFrecuencies, jsonOutputPath);

            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                //borra arch temp
                deleteTemporaryFiles(tempFiles);
            }
        }
    }
    //1. Lee  las frecuencias de todos los archivos//2-suma...

    private static Map<String, Integer> readAndSumFrec(String[] filePaths) throws IOException {
        Map<String, Integer> totalFrecuencies = new HashMap<>();
        for (String element : filePaths) {

            try (BufferedReader br = new BufferedReader(new FileReader(new File(element)))) {
                br.lines().forEach(e -> {
                    try {
                        String[] eParts = e.split(",");
                        if (eParts.length < 2) {
                            System.err.println("Error: la linea no tiene las dos partes");

                        } else {
                            String word = eParts[0].trim();
                            int frequency = Integer.parseInt(eParts[1].trim());
                            totalFrecuencies.put(word, totalFrecuencies.getOrDefault(word, 0) + frequency);
                        }

                    } catch (NumberFormatException ex) {
                        System.err.println(ex.getMessage());
                    }
                });
            } catch (IOException e) {
                System.err.println(e.getMessage());
                throw e;
            }



        }
        return totalFrecuencies;
    }
        private static void writeTopFrecuenciasToJson (Map < String, Integer > totalMap, String jsonFilePath) throws
        IOException {
            List<Map.Entry<String, Integer>> sortedList = totalMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(5)
                    .toList();
            Map<String, Integer> topFive = new LinkedHashMap<>();

            for (Map.Entry<String, Integer> element : sortedList) {
                topFive.put(element.getKey(), element.getValue());
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(jsonFilePath))) {
                writer.println("{");
                writer.println("  \"Top 5 palabras más frecuentes\": [");

                int i = 1;
                int total = topFive.size();
                for (Map.Entry<String, Integer> e : topFive.entrySet()) {
                    writer.println("    {\"top\": " + i +
                            ", \"palabra\": \"" + e.getKey() +
                            "\", \"frecuencia\": " + e.getValue() +
                            "}" + (i < total ? "," : ""));
                    i++;
                }
                writer.println("  ]");
                writer.println("}");
            }
        }
        private static void deleteTemporaryFiles (String[]filePaths){
            for (String element : filePaths) {
                File tempFile = new File(element);
                if (tempFile.exists()) {
                    tempFile.delete();
                }
            }
        }
    }
