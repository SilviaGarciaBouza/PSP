package practicas.practicas2entregar.practica1;
/*
* Implementa un programa en Java que simule el tráfico ferroviario entre dos estaciones (A y B) conectadas por una única vía.

Solo pueden circular trenes en una dirección a la vez, por lo que los trenes deben coordinarse para evitar colisiones.

El programa deberá gestionar el acceso a la vía usando sincronización, exclusión mutua y comunicación entre hilos.*/



/*
*

Debe implementar los métodos necesarios para gestionar la entrada y la salida a la vía por parte de los trenes.

En caso de que la vía esté siendo utilizada en dirección contraria, el tren deberá esperar a que quede libre.

Una vez que un tren abandona una vía dede avisar al resto de trenes.*/

import java.util.LinkedList;
import java.util.Queue;

public class RailwayControl {
    /*Debe usar variables sincronizadas que indiquen:

Si la vía está libre.

Cuántos trenes circulan actualmente.

En qué dirección se está usando la vía.*/
    private boolean isFree;
    private int trainsCurrent;
    private String directionCurrent;
    private Queue<Train> queue;
    private final int MAXTRAINS=3;

    public RailwayControl() {
        this.trainsCurrent = 0;
        this.directionCurrent = "";
        this.queue = new LinkedList<>();
    }




    public synchronized void enter(Train train) throws InterruptedException {
       this.directionCurrent =(trainsCurrent==0)? train.getDirection() : directionCurrent;
        while ((trainsCurrent > 0 && !directionCurrent.equals(train.getDirection()))
                || trainsCurrent == MAXTRAINS) {
            System.out.println(train.getName() + " espera");
            wait();
        }
        if (trainsCurrent == 0) {
            this.directionCurrent = train.getDirection();
        }
        System.out.println(train.getName()+" entra en la vía " + train.getDirection());
        queue.add(train);
        trainsCurrent++;
        this.directionCurrent = train.getDirection();
        notifyAll();
    }

    public synchronized void  exit(Train train) throws InterruptedException {
        while (queue.peek() != train){
            wait();
        }
        queue.remove(train);
        trainsCurrent--;
        if (trainsCurrent == 0) {
            this.directionCurrent = "";
            System.out.println("Vía libre ");
            notifyAll();
        } else {
            notifyAll();
        }
    }

}
