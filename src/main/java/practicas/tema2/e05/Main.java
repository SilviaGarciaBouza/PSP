package practicas.tema2.e05;

public class Main {
    public static void main(String[] args) throws InterruptedException {



        BankAccount b = new BankAccount(1000);
        Thread t1 = new Thread(new Client(b, 2, 200));
        Thread t2 = new Thread(new Client(b, 2, 200));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
