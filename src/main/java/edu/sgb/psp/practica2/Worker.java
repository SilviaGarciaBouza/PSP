package edu.sgb.psp.practica2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Worker {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Error: se necesitan 4 argumentos");
        } else {
            String fileInputPath = args[0];
            int startLine = Integer.parseInt(args[1]);
            int endLine = Integer.parseInt(args[2]);
            String tempFileOutputPath = args[3];
            try {
                //1-Lee únicamente su rango de líneas y //2-Calcula la frecuencia de cada palabra en su bloque.
                Map<String, Integer> wordFrequencies;
                wordFrequencies = readAndCountBlock(fileInputPath, startLine, endLine);
                //3-Guarda el resultado en un archivo tempnoral
                saveResults(wordFrequencies, tempFileOutputPath);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    //1-Lee únicamente su rango de líneas
    private static Map<String, Integer> readAndCountBlock(String fileInputPath, int startLine, int endLine) throws IOException {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileInputPath))) {
            String line;
            int currentLine = 1;
            while ((line = reader.readLine()) != null) {
                if (currentLine >= startLine && currentLine <= endLine) {
                    calculateFrequenciesInLine(line, wordFrequencies);
                }
                if (currentLine > endLine) {
                    break;
                }
                currentLine++;
            }
        }
        return wordFrequencies;
    }

    //2-Calcula la frecuencia de cada palabra en su bloque.
    private static void calculateFrequenciesInLine(String line, Map<String, Integer> wordFrequencies) {
        if (line == null || line.trim().isEmpty()) {
        } else {
            String[] words = line.toLowerCase().replaceAll("[(){}\"@#~%¬&.,;:?¿¡!]", " ").split("\\s+");
            for (String element : words) {
                if (!element.isEmpty()) {
                    wordFrequencies.put(element, wordFrequencies.getOrDefault(element, 0) + 1);
                }
            }
        }
    }

    //3-Guarda el resultado en un archivo temporal
    private static void saveResults(Map<String, Integer> wordFrequencies, String tempFilePath) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tempFilePath))) {
            for (Map.Entry<String, Integer> element : wordFrequencies.entrySet()) {
                writer.println(element.getKey() + "," + element.getValue());
            }
        }
    }
}