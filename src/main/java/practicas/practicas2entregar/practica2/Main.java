package practicas.practicas2entregar.practica2;

import java.util.Scanner;

/*
Clase Main

Crea una instancia de KitchenManager con un número N de cocineros (y N espátulas).

Lanza N hilos Chef.

El programa debe poder ejecutarse indefinidamente sin bloqueos.*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        KitchenManager km= new KitchenManager(4);


        Thread tChef0= new Thread(new Chef(0,km,4));
        Thread tChef1= new Thread(new Chef(1,km,4));
        Thread tChef2= new Thread(new Chef(2,km,4));
        Thread tChef3= new Thread(new Chef(3,km,4));

        tChef0.start();
        tChef1.start();
        tChef2.start();
        tChef3.start();

        tChef0.join();
        tChef1.join();
        tChef2.join();
        tChef3.join();





}}
