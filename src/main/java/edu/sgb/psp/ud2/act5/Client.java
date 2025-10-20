package edu.sgb.psp.ud2.act5;

public class Client implements Runnable {
    private int numberWithdraw;
    private int quantity;
    BankAccount bc;


    public Client(int numberWithdraw, int quantity, BankAccount bc) {

        this.numberWithdraw = numberWithdraw;
        this.quantity = quantity;
        this.bc = bc;
    }
    @Override
    public void run() {
        for(int i= 0; i<numberWithdraw;i++){
            System.out.println(Thread.currentThread().getName()+" va a retirar "+quantity);
            if(bc.withdraw(quantity)){
                System.out.println(Thread.currentThread().getName()+" completó la retirada. Saldo restante: " + bc.getBalance());

            }else{
                System.out.println(Thread.currentThread().getName()+" no puede retirar: saldo insuficiente.");

            }
        }

    }
}
