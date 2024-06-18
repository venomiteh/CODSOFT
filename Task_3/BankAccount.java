package Task_3;

import java.util.Random;

public class BankAccount {

private double Balance;
private String id;
private double interestRate;
private static int idNb=1;



public BankAccount(double balance,double interestRate){
    Random random=new Random();
this.Balance=balance;
this.interestRate=interestRate;
this.id=idNb+"-"+random.nextInt(1000,5000);
idNb++;

}


    public double getBalance() {
        return Balance;
    }


    public void deposit(double amount) {
        this.Balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= Balance) {
            this.Balance -= amount;
            return true;
        } else {
            System.out.println("You do not have enough money in your Account!");
            return false;
        }
    }












    }




