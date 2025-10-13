package edu.sgb.psp.ud2.act3;

import java.util.Random;

public class ReaderTask implements Runnable {
    private Random rand = new Random();

    @Override
    public void run() {
        System.out.println("[Reader] Starting...");
        int duration = 1000 + rand.nextInt(3000); // entre 1 y 3 segundos
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println("[Reader] Interrupted!");
            return;
        }
        System.out.println("[Reader] Finished after " + duration + " ms.");
    }
}