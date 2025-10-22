package edu.sgb.psp.ud2.act6;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        CarWash carWash = new CarWash();
        Car c1 = new Car(carWash, "coche1");
        Car c2 = new Car(carWash, "coche2");
        Car c3 = new Car(carWash, "coche3");
        Car c4 = new Car(carWash, "coche4");
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();

        t2.join();
        t3.join();
        t4.join();


    }
}