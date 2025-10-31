package practicas.practicas2entregar.practica2;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class KitchenManager {
    private int capacity = 2;
    private Semaphore semEspatulas;
    private Semaphore mutex;

    private Queue<String> queue;
}
