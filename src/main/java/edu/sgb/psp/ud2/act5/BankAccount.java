package edu.sgb.psp.ud2.act5;

public class BankAccount {
    private int balance;
    public synchronized boolean  withdraw(int retirado){
        if(balance>=retirado){
            balance-=retirado;
            try {
            Thread.sleep(3000);
            return true;

            }catch (Exception e){

            }
        }return false;

    }

    public synchronized int getBalance() {
        return balance;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }
}
