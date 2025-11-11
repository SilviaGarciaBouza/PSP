package ejerciciostema2;

public class E01 {
    Thread t = new Thread(new CustomTask("a", 2));

}


class CustomTask implements Runnable{
    String name;
    int duration;
    public CustomTask(String name, int dur){
        this.name= name;
        this.duration= dur;
    }

    @Override
    public void run() {
        System.out.println(duration+name);
    }


}