package practicas.practicas2entregar.practica2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class KitchenManager {
    private int numSpatuls;
    private Semaphore[] semSpatul;


    public KitchenManager(int numSpatuls ){

    this.numSpatuls= numSpatuls;
        this.semSpatul= new Semaphore[numSpatuls];
        for(int i=0; i<numSpatuls; i++) {
            this.semSpatul[i]= new Semaphore(1);
        }

    }
    public void acquireSpatulas (int derecha, int izquierda, int idChef) throws InterruptedException {
        // PAR: Coge IZQUIERDA primero
           //todo poner esto asi o preguntar si tiene q ser asi
         // IMPAR: Coge DERECHA primero




        System.out.println("Chef " + idChef + " intenta coger espátula [derecha]");
        semSpatul[derecha].acquire();
        System.out.println("Chef " + idChef + " cogio espátula [derecha]");
        System.out.println("Chef " + idChef + " intenta coger espátula [izquierda]");
        semSpatul[izquierda].acquire();
        System.out.println("Chef " + idChef + " cogio espátula [izquierda]");




    }
    public void releaseSpatulas (int derecha, int izquierda) throws InterruptedException {
        semSpatul[derecha].release();
        semSpatul[izquierda].release();

    }


}
