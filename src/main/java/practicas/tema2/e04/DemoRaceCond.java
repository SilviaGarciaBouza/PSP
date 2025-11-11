package practicas.tema2.e04;

public class DemoRaceCond {
    public static void main(String[] args) {
        Counter c= new Counter();
        Thread t1 = new Thread(()->{c.incrementar();});
        Thread t2 = new Thread(()->{c.incrementar();});
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Valor real: " + c.getValue());


    }
}
