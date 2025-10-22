package edu.sgb.psp.ud2.act7;

public class Waiter implements Runnable{
    KitchenQueue kc;

    public Waiter(KitchenQueue kc) {
        this.kc = kc;
    }

    @Override
    public void run() {

        try {
            do{
            kc.takeDish();
            Thread.sleep(3000);}
            while(!kc.getQueue().isEmpty());
        } catch (InterruptedException e) {




        }
    }
}
