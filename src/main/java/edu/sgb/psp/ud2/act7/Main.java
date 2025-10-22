package edu.sgb.psp.ud2.act7;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<String > queue= new LinkedList<>();
        KitchenQueue kc= new KitchenQueue(queue, 5);
        Thread chef= new Thread(new Chef(kc,6));
        Thread waiter= new Thread(new Waiter(kc));

        chef.start();
        waiter.start();

        chef.join();
        waiter.join();
    }

}
