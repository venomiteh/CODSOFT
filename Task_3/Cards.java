package Task_3;

public class Cards {

    private int CardNumber;
    private int Pin;


    private int cvv;
   private BankAccount account;

public Cards(int pin,int cvv,double Balance,double interestRate,int CardNB){
    this.account=new BankAccount(Balance,interestRate);
    this.CardNumber=CardNB;
    this.Pin=pin;
    this.cvv=cvv;
}

public void setPin(int pin){
    this.Pin=pin;
}

public int getCardNumber(){
    return CardNumber;
}

public int getPin(){
    return Pin;
}

public BankAccount getAccount(){
    return account;
}

}
