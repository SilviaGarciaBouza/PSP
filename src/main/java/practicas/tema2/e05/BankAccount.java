package practicas.tema2.e05;

public class BankAccount {
    int balance;
    public void withdraw(int num){
        if(balance>=num){
            balance-=num;

        }else{
            System.out.println("no hay din sufi");
        }
    }
    public int BankAccount(){
        return balance;
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }
}
