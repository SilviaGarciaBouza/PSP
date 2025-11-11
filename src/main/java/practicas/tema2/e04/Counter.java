package practicas.tema2.e04;

public class Counter implements Runnable{
    int value;
    void incrementar(){
        value++;
    }
    public int getValue(){
        return value;
    }

    @Override
    public void run() {

    }
}
