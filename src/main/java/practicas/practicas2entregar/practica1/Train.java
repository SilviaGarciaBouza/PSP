package practicas.practicas2entregar.practica1;

/*
Clase Train

Implementa la interfaz Runnable.

Debe incluir:

Nombre del tren.

Dirección en la que circula.

Referencia a RailwayControl

Su funcionamiento es el siguiente:

Debe mostrar un mensaje cuando vaya intentar entrar en la vía.

Simula el tiempo de trayecto con Thread.sleep().

Y finalmente, abandona la via y muestra un mensaje.*/
public class Train implements Runnable{
    private String name;
    private String direction;
    private RailwayControl railwayControl;

    public Train(String name, String direction, RailwayControl railwayControl) {
        this.name = name;
        this.direction = direction;
        this.railwayControl = railwayControl;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+" intenta entrar en la via "+direction);
            railwayControl.enter(this);
            Thread.sleep(1000);
            System.out.println(name+" sale");
            railwayControl.exit(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }
}
