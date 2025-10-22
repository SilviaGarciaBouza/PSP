package edu.sgb.psp.ud2.act6;

public class Car implements Runnable{
    private CarWash cw;
   private String carName;

    public Car(CarWash cw, String carName) {
        this.cw = cw;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            cw.enter(carName);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            cw.exit(carName);
        }
    }
}
