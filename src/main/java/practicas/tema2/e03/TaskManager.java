package practicas.tema2.e03;

import java.util.Random;

public class TaskManager {
    public static void main(String[] args) throws InterruptedException {


        Thread tr = new Thread(new ReaderTask());
        Thread tp = new Thread(new ProcessorTask());
        Thread trep = new Thread(new ReporterTask());

        tr.start();
        trep.start();
        tr.join();
        tp.start();
        trep.join(6000);
        System.out.println(tr.isAlive());
        System.out.println(trep.isAlive());
        System.out.println(tp.isAlive());

    }
}



 class ReaderTask implements Runnable {
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

 class ProcessorTask implements Runnable {
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


 class ReporterTask implements Runnable {
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