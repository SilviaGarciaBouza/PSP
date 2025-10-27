package edu.sgb.psp.ud2.act7;

import java.util.Queue;

public class KitchenQueue {
   private Queue<String> queue;//aqui no se inicializa pq
  private int  capacity;

    public KitchenQueue(Queue<String> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    synchronized void putDish(String dish) throws InterruptedException {
        while(queue.size()==capacity){
            System.out.println(dish+" espera el cocinero");

            wait();
        }
        System.out.println(dish+" añadido el cocinero");

        queue.add(dish);

        notifyAll();
    }

    synchronized void takeDish() throws InterruptedException {
        while(queue.isEmpty()){
            System.out.println("camarero espera");

            wait();
        }
        System.out.println("camarero recoje un plato");

        queue.poll();

        notifyAll();

    }

    public Queue<String> getQueue() {
        return queue;
    }
}
