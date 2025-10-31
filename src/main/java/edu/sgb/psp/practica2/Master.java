package edu.sgb.psp.practica2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Master {

    static String fusPath;
    static String fusOutPath;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileInputPath;
        int numberProcess;
        String numberStringProcess;
        String fusionerUsed;
        do {
            System.out.println("Introduce la ruta del archivo: ");
            fileInputPath = sc.nextLine();
            if (new File(fileInputPath).isFile()) {
                System.out.println("El archivo existe");
            } else {
                System.err.println("Error: El archivo no existe");
            }
        } while (!new File(fileInputPath).isFile());
        do {
            do {
                System.out.println("Introduce el numero de procesos: ");
                numberStringProcess = sc.nextLine();
                if (!numberStringProcess.matches("[0-9]+")) {
                    System.err.println("Error: lo que introdujiste no era un numero");
                }
            } while (!numberStringProcess.matches("[0-9]+"));
            numberProcess = Integer.parseInt(numberStringProcess);
            if (numberProcess <= 0) {
                System.err.println("Error: el numero debe ser mayor a 0");
            }
        } while (numberProcess <= 0);
        do {
            System.out.println("Que Fusioner quieres usar (jsonfusioner/fusioner/python)?");
            fusionerUsed = sc.nextLine().toLowerCase();
            if (fusionerUsed.equals("jsonfusioner")) {
                fusPath = "edu.aabsgb.psp.practicas.practica2.FusionerJson";
                File inputFile = new File(fileInputPath);
                String inputDirectory = inputFile.getParent();
                fusOutPath = inputDirectory + File.separator + "textTestJson.json";
            } else if (fusionerUsed.equals("fusioner")) {
                fusPath = "edu.aabsgb.psp.practicas.practica2.Fusioner";
                fusOutPath = "";
            } else if (fusionerUsed.equals("python")) {
                fusPath = "pythonFusioner";
                fusOutPath = "";
            } else {
                System.err.println("Error: Las opciones son jsonfusioner ,  fusioner o python");
            }
        } while (!fusionerUsed.equals("jsonfusioner") && !fusionerUsed.equals("fusioner") && !fusionerUsed.equals("python"));
        try {
            // 2. Dividir el archivo en N bloques de líneas
            List<String[]> workerArgsList = splitFileIntoBlocks(fileInputPath, numberProcess);

            // 3. Lanzar N procesos worker
            List<Process> workers = throwWorker(workerArgsList);

            // 4. LAnzar el Fusioner
            coordinateFusion(workers, workerArgsList);

        } catch (IOException e) {
            System.err.println(e.getMessage());

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());


        }
    }

    //2-Dividir el archivo en N bloques de líneas
    private static List<String[]> splitFileIntoBlocks(String filePath, int nProcesses) throws IOException {
        List<String[]> workerArgsList = new ArrayList<>();
        int totalLines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                totalLines++;
            }
        }
        if (totalLines == 0 || nProcesses == 0) return workerArgsList;
        int blockSice = totalLines / nProcesses;
        int remainder = totalLines % nProcesses;
        int currentLine = 1;
        for (int i = 0; i < nProcesses; i++) {
            int currentBlockSize = blockSice + (i < remainder ? 1 : 0);
            int startLine = currentLine;
            int endLine = currentLine + currentBlockSize - 1;

            File inputFile = new File(filePath);

            String outFileName = inputFile.getParent() + File.separator + "outputFile" + i;

            String[] args = {
                    filePath,
                    String.valueOf(startLine),
                    String.valueOf(endLine),
                    outFileName
            };
            workerArgsList.add(args);
            currentLine = endLine + 1;
        }
        return workerArgsList;
    }

    //3-Lanzar N procesos worker
    private static List<Process> throwWorker(List<String[]> workerArgsList) throws IOException {
        List<Process> workers = new ArrayList<>();
        String classpath = System.getProperty("java.class.path");
        for (String[] element : workerArgsList) {
            List<String> command = new ArrayList<>();
            command.add("java");
            command.add("-cp");
            command.add(classpath);
            command.add("edu.aabsgb.psp.practicas.practica2.Worker");
            for (String e : element) {
                command.add(e);
            }
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.inheritIO();
            Process worker = pb.start();
            workers.add(worker);
        }
        return workers;
    }

    // 4.  Laanzar el Fusioner
    private static void coordinateFusion(List<Process> workers, List<String[]> workerArgsList) throws InterruptedException, IOException {
        for (Process element : workers) {
            element.waitFor();
        }
        List<String> tempFiles = new ArrayList<>();
        for (String[] element : workerArgsList) {
            tempFiles.add(element[3]);
        }
        // 4. LAnzar el Fusioner
        throwFusioner(tempFiles);
    }

    private static void throwFusioner(List<String> tempFiles) throws IOException {
        String classpath = System.getProperty("java.class.path");
        List<String> command = new ArrayList<>();
        if (fusPath.equals("pythonFusioner")) {
            String projectRoot = new File("").getAbsolutePath();
            String fusionerScriptPath = projectRoot + File.separator + "python" + File.separator + "FusionerPython.py";
            command.add("python");
            command.add(fusionerScriptPath);
        } else {
            command.add("java");
            command.add("-cp");
            command.add(classpath);
            command.add(fusPath);


        }
        if (fusPath.equals("edu.aabsgb.psp.practicas.practica2.FusionerJson")) {
            command.add(fusOutPath);
        }
        command.addAll(tempFiles);
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.inheritIO();
        Process fusioner = pb.start();
        try {
            fusioner.waitFor();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}





