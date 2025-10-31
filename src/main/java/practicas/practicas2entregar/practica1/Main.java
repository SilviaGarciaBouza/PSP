package practicas.practicas2entregar.practica1;

/*
Clase Main

Crea una instancia de RailwayControl

Crea y lanza varios trenes en ambas direcciones de forma aleatoria.

Los hilos deben ejecutarse en paralelo.*/
public class Main {
    public static void main(String[] args) {
        RailwayControl railwayControl = new RailwayControl();
        Train train1 = new Train("Train 1", "A→B", railwayControl);
        Train train2 = new Train("Train 2", "B→A", railwayControl);
        Train train3 = new Train("Train 3", "A→B", railwayControl);
        Train train4 = new Train("Train 4", "B→A", railwayControl);
        Train train5 = new Train("Train 5", "A→B", railwayControl);
        Train train6 = new Train("Train 6", "B→A", railwayControl);
        Thread thread1 = new Thread(train1);
        Thread thread2 = new Thread(train2);
        Thread thread3 = new Thread(train3);
        Thread thread4 = new Thread(train4);
        Thread thread5 = new Thread(train5);
        Thread thread6 = new Thread(train6);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
