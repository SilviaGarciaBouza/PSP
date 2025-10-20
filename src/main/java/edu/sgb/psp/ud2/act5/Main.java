package edu.sgb.psp.ud2.act5;

public class Main {

    public static void main(String[] args) {


    BankAccount ba= new BankAccount(1000);
    Client c1= new Client(1,200,  ba);
    Client c2= new Client(3,200,  ba);
    Client c3= new Client(5,200,  ba);

     Thread t1= new Thread(c1, "Cliente1");
    Thread t2= new Thread(c2, "Cliente2");
    Thread t3= new Thread(c3, "Cliente3");
    try{
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }catch (Exception e){
        System.out.println();
    }
        System.out.println("el valor es "+ba.getBalance());

}}
