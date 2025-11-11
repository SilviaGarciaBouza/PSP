package ejerciciostema2.E03;

public class TaskManager {
    Thread reader = new Thread();

    public Thread getReader() {
        return reader;
    }

    Thread processor = new Thread();
    Thread reporter = new Thread();
}
