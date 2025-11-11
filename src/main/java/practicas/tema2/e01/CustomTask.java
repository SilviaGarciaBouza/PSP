package practicas.tema2.e01;

public class CustomTask implements Runnable{

    String taskName;
    int duration;

    public CustomTask(String taskName, int duration) {
        this.taskName = taskName;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(taskName+" empieza: duracion "+duration);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Termina");

    }




}
