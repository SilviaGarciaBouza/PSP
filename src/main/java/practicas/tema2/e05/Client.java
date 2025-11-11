package practicas.tema2.e05;

public class Client implements Runnable {
    BankAccount b;
    int numRetiradas;
    int cantidadRetirada;

    public Client(BankAccount b, int numRetiradas, int cantidadRetirada) {
        this.b = b;
        this.numRetiradas = numRetiradas;
        this.cantidadRetirada = cantidadRetirada;
    }

    @Override
    public void run() {
        for(int i=0; i<numRetiradas;i++){
            b.withdraw(cantidadRetirada);
        }
    }

}
