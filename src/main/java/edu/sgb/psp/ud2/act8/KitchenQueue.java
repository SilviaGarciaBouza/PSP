package edu.sgb.psp.ud2.act8;

import java.util.Queue;
import java.util.concurrent.Semaphore;


public class KitchenQueue {
    private int  capacity;
    Semaphore sem1huecos = new Semaphore(capacity);
    Semaphore sem2platos = new Semaphore(capacity - sem1huecos.availablePermits());
    Semaphore sem3exceso = new Semaphore(1);

    private Queue<String> queue;


    public KitchenQueue(Queue<String> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public void putDish(String dish) throws InterruptedException {
        sem1huecos.acquire();
        queue.add(dish);
        sem1huecos.release();


    }

    public void takeDish() throws InterruptedException {



    }

    public Queue<String> getQueue() {
        return queue;
    }
}
