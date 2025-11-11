package ejerciciostema2.e1;

import edu.sgb.psp.ud2.act5.BankAccount;
import edu.sgb.psp.ud2.act5.Client;
import edu.sgb.psp.ud2.act7.Chef;

import java.util.Queue;
import java.util.Random;


class KiQ {
    Queue q;
    int capacity;

    void putDish(String d, Chef c) {

            while(q.size()== capacity){
                c.wait();
            }
            q.add(d);
            notifyAll();
}
void takeDish(String d, Waiter w) throws InterruptedException {
        while (q.isEmpty()){
            w.wait();
        }
        q.poll();
        notifyAll();
}
}

class Chef implements Runnable{
    KiQ k;
    String p;


    @Override
    public void run() {
for (int i=0; i<6;i++){
    try {
        k.putDish("Plato", this);
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
    }
}

class Waiter implements Runnable{
    KiQ k;
    String p;

    @Override
    public void run() {
for (int i=0; i<6;i++){
    try {
        k.takeDish("Plato", this);
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
    }
}


class m{
    public static void main(String[] args) {
        KiQ k = new KiQ();
        Chef c = new Chef(k, "Plato");
        Waiter w = new Waiter(k, "Plato");
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(w);
        t1.start();
        t2.start();
    }
}