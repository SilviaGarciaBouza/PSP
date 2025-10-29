package edu.sgb.psp.ud2.act8;

import java.util.Queue;
import java.util.concurrent.Semaphore;


public class KitchenQueueSem {
    private int  capacity;
    private Semaphore sem1huecos;
    private Semaphore sem2platos;
    private Semaphore sem3exceso;

    private Queue<String> queue;


    public KitchenQueueSem(Queue<String> queue, int capacity) {
        this.sem1huecos = new Semaphore(capacity);
        this.sem2platos = new Semaphore(0);
        this.sem3exceso = new Semaphore(1);
        this.queue = queue;
        this.capacity = capacity;
    }

    public void putDish(String dish) throws InterruptedException {
        System.out.println("hola");//todos
        sem1huecos.acquire();//a partid de aqui solo pueden los permitidos, antes todos una vez q limitas a quantity
        System.out.println("adios");//este codigo todos los capacity
        sem3exceso.acquire();//asi lo siguiente solo lo puede ejecutar uno de cada vez
        queue.add(dish);
        sem3exceso.release();
        System.out.println("cocinero añade iun plato");//solo de uno en uno
        sem1huecos.release();// así aumenta el permitsa uno


    }

    public void takeDish() throws InterruptedException {
        sem1huecos.acquire();
        sem3exceso.acquire();
        queue.poll();
        sem3exceso.release();
        sem1huecos.release();
    }

    public Queue<String> getQueue() {
        return queue;
    }
}
