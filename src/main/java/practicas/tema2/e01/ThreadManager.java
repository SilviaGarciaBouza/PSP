package practicas.tema2.e01;

public class ThreadManager {
    public static void main(String[] args) throws InterruptedException {
        CustomTask c1= new CustomTask("a", 1000);
        CustomTask c2= new CustomTask("b", 1000);
        CustomTask c3= new CustomTask("c", 1000);

        Runnable r1= new Runnable() {
            @Override
            public void run() {
                System.out.println(" empieza: duracion ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Termina");
            }
        };

        Runnable r2= () -> {
            System.out.println(" empieza: duracion ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Termina");
        };
        Thread t1= new Thread(c1);
        t1.start();
        t1.join(6000);
        t1.interrupt();

    }
}
