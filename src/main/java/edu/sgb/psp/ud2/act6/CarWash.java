package edu.sgb.psp.ud2.act6;

public class CarWash {
    boolean occupied;

    public CarWash() {
        occupied = false;
    }

    synchronized void enter(String carName) throws InterruptedException {
        while (occupied) {
            System.out.println(carName+" Ocupada");
            System.out.println(carName+"\uD83D\uDE97 espera");

            wait();
        }
        System.out.println(carName+"\uD83D\uDE99 Entra a ocupar");
            occupied = true;
            Thread.sleep(5000);
        System.out.println(carName+" Deja de ocupar");

    }

    public synchronized void exit(String carname) {
        occupied=false;
        System.out.println(carname+" ✅libre");
        notifyAll();
    }
}
