package edu.sgb.psp.ud2.act1;

public class ThreadMAnager {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // --- Part 1: Usando CustomTask class ---
        CustomTask ct1 = new CustomTask("CustomTask1", 1000);
        CustomTask ct2 = new CustomTask("CustomTask2", 2000);
        CustomTask ct3 = new CustomTask("CustomTask3", 3000);
        // --- Part 2: Usando clases anónimas ---
        Runnable run1 = new Runnable() {
            public void run() {
                System.out.println("Empieza la ejecución de la tarea.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Terminada la ejecución de la tarea.");
            };
        };
            // --- Part 3: Usando lambda ---
        Runnable run2= () ->{
            System.out.println("Empieza la ejecución de la tarea.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Terminada la ejecución de la tarea.");};

Thread t1 = new Thread(ct1);
Thread t2 = new Thread(ct2);
Thread t3 = new Thread(ct3);
Thread t4 = new Thread(run1);
Thread t5 = new Thread(run2);

t1.start();
t2.start();
t3.start();
t4.start();
t5.start();



    }
}