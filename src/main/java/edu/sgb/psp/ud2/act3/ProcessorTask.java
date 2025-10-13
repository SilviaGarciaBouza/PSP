package edu.sgb.psp.ud2.act3;

import java.util.Random;

public class ProcessorTask implements Runnable {
    private Random rand = new Random();

    @Override
    public void run() {
        System.out.println("[Processor] Starting...");
        int duration = 2000 + rand.nextInt(5000); // Entre 2 y 5 segundos
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println("[Processor] Interrupted!");
            return;
        }
        System.out.println("[Processor] Finished after " + duration + " ms.");
    }
}