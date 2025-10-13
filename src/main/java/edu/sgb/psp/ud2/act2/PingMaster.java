package edu.sgb.psp.ud2.act2;

public class PingMaster {
    public static void main(String[] args) {
        PingTask pt1= new PingTask("8.8.8.8",3,"task1");
        PingTask pt2= new PingTask("2.2.2.2",2,"task2");
        Thread thread1= new Thread(pt1);
        Thread thread2= new Thread(pt2);
        thread1.start();
        thread2.start();

        //esperar a q termine?hacer y probar
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}
