package com.bankaccount;

public class BankClass {
    long money;
    char type;

    public BankClass(long money, char type) throws WrongCharacterInputException{
        this.money=money;
        this.type=type;
        if(this.type!='c'&& this.type!='C'&& this.type!='S'&& this.type!='s'){
            WrongCharacterInputException characterInputException=new WrongCharacterInputException();
            throw characterInputException;
        }

    }
    public void deposit(long moneyDeposited){
        money=money+moneyDeposited;
    }
    public void withdraw(long moneyWithdrawn) throws AccountBalanceNegativeException{
        money=money-moneyWithdrawn;

        if(money<0){
            if(type=='C'|| type=='c'){
                System.out.println("ACCOUNT BALANCE IN NEGATIVE:" + money);

            }
            else{
                AccountBalanceNegativeException negativeException=new AccountBalanceNegativeException();
                throw negativeException;
            }
        }
    }
    public void interest(){
        System.out.println("INTEREST FOR PERIOD OF QUARTER: ");
        if(type=='C'|| type=='c'){
            System.out.println("GOPAL: INTEREST IS 0");
        }
        else{
            float interest=(money*3)/4;
            System.out.println("AMRITA: INTEREST IS" + interest);


        }
    }
    public static void main(String[] args) throws AccountBalanceNegativeException,WrongCharacterInputException{
        // write your code here
        BankClass gopal=new BankClass(50000,'c');
        BankClass amrita=new BankClass(100000,'s');
        gopal.deposit(10000);
        amrita.withdraw(45000);
        gopal.interest();
        amrita.interest();
        gopal.withdraw(70000);
        gopal.interest();

    }
}
