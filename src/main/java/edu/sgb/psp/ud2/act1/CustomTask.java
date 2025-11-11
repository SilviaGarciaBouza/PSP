package edu.sgb.psp.ud2.act1;

public class CustomTask implements Runnable{
    String taskName;
    int duration;

    public CustomTask(String taskName, int duration) {
        this.taskName = taskName;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println("Empieza la ejecución de la tarea." +
                "Duracion: "+this.duration+" milisegundos");
        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Terminada la ejecución de la tarea.");
    }
}
