package edu.sgb.psp.ud2.act3;
import java.util.Random;

public class ReporterTask implements Runnable {
    private Random rand = new Random();

    @Override
    public void run() {
        System.out.println("[Reporter] Starting...");
        int duration = 3000 + rand.nextInt(15000); // Entre 3 y 15 segundos
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println("[Reporter] Interrupted!");
            return;
        }
        System.out.println("[Reporter] Finished after " + duration + " ms.");
    }
}