package practicas.practicas2entregar.practica2;



import java.util.Random;

/*
Implementa la interfaz Runnable.

Debe incluir:

Un identificador (puede ser un número)

Referencia a KitchenManager

Su funcionamiento es el siguiente:

Repite varias veces el ciclo de preparar ingredientes y cocinar .

Simula un tiempo de preparación de ingredientes.

Antes de cocinar, debe hacerse con las dos espátulas.

Simula un tiempo de cocinado.

Finalmente termina de cocinar y deja libres las espátulas.

Debe mostrar mensajes que indiquen su estado actual, ejemplo:

Preparando ingredientes...

Intentando coger espátulas...

Cocinando...

Dejando espátulas...

*/
public class Chef implements Runnable{
    private int id;
    private KitchenManager km;
    private  int izquierda;
    private int derecha;

    public Chef(int id, KitchenManager km, int numTotal) {
        this.id = id;
        this.km = km;
        this.izquierda = id;
        this.derecha = (id+1)%numTotal;
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++){
            try {
                System.out.println("Chef "+id+" preparando ingredientes...");
                Thread.sleep( new Random().nextInt(500, 2000));

                System.out.println("Chef "+id+" Intentando coger espátulas...");
                km.acquireSpatulas(derecha, izquierda, id);

                System.out.println("Chef "+id+" cocinando...");
                Thread.sleep( new Random().nextInt(500, 2000));

                System.out.println("Chef "+id+" dejando espatulas.....");
                km.releaseSpatulas(derecha, izquierda);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

