package edu.sgb.psp.ud1.act2;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ProcessDouble {
    static Scanner sc = new Scanner(System.in);
    static String IP = "8.8.8.8";
    static int TIMEOUT = 2;
    static TimeUnit STANDARDUNIT = TimeUnit.SECONDS;

    public static void crearProcesoPing(String ip, int pings, int timeout) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("ping", ip, "-n", Integer.toString(pings));
        pb.inheritIO();
        System.out.println("Estado: LISTO (READY)");

        Process p = pb.start();
        Instant start = Instant.now();
        System.out.println("Estado: EN EJECUCIÓN (RUNNING)");

        boolean exitCode = p.waitFor(timeout, STANDARDUNIT);
        if (!exitCode) p.destroyForcibly();
        Instant end = Instant.now();
        long duracion = Duration.between(start, end).toMillis();
        System.out.println("Estado: FINALIZADO (TERMINATED), código de salida: " + exitCode);
        System.out.println("Duración: " + duracion + " ms");
    }


    public static void main(String[] args) {

        try {

            IntStream.of(2, 5)
                    .parallel()
                    .forEach(n -> {
                        try {
                            crearProcesoPing(IP, n, TIMEOUT);
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });


        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
