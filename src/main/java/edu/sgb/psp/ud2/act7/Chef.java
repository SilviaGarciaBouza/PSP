package edu.sgb.psp.ud2.act7;

public class Chef implements Runnable{
    private KitchenQueue kc;
    private int numDishes;

    public Chef(KitchenQueue kc, int numDishes) {
        this.kc = kc;
        this.numDishes = numDishes;
    }

    @Override
    public void run() {
        for(int i=0; i<numDishes;i++){
            try {
                kc.putDish("Plato"+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
