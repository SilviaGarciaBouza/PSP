package edu.sgb.psp.ud2.act3;

public class TaskManager {
    public static void main(String[] args) {
        //objetos
        ReaderTask readerTask = new ReaderTask();
        ProcessorTask processorTask = new ProcessorTask();
        ReporterTask reporterTask = new ReporterTask();
        //hilo con cada objeto
        Thread threadReader= new Thread(readerTask);
        Thread threadProcessor= new Thread(processorTask);
        Thread threadReporter= new Thread(reporterTask);
       //empieza
        threadReader.start();
        threadProcessor.start();
        try {
            threadReader.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        threadReporter.start();
        try {
            threadReporter.join(6000);
            threadProcessor.interrupt();
            System.out.println("[Main] Reporter is too slow, interrupting...");
            System.out.println("[Reporter] Interrupted!");
        }catch (InterruptedException e){
        System.out.println(e.getMessage());
    }
       //Al final, el programa debe mostrar qué tareas siguen activas y cuáles no.
       Boolean readerAlive= threadReader.isAlive();
       Boolean processAlive= threadProcessor.isAlive();
       Boolean reporterAlive= threadReporter.isAlive();
       int count=0;
       if(!readerAlive){
           count++;
       }
       if(!processAlive){
           count++;
       }
       if(!reporterAlive){
           count++;
       }
        System.out.println("Reader alive? "+readerAlive);
        System.out.println("Processor alive? "+processAlive);
        System.out.println("Reporter alive? "+reporterAlive);
        if(count==3) {
            System.out.println("[Main] All tasks finished.");
        }else {
            System.out.println("[Main] "+count+" tasks finished.");
        }
    }
}
