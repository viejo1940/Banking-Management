package BankingProject;


import java.util.*;

public class Acount {
    private  double balance;
    private final List<Operation> operations;

    public Acount(){
        this.balance=0.0;
        this.operations = new ArrayList<>();
    }

    public List<Operation> getOperations() {
        return operations;
    }
    public void addOperation(Operation operation) {
        operations.add(operation);
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if (amount>0){
            Operation depositOperation=new Operation("deposite",amount,new Date());
            addOperation(depositOperation);
            balance+=amount;
            System.out.println("Deposit: "+ amount + " $ ");
            System.out.println("new Balance : "+ balance +" $ ");
        }else {
            System.out.println("Deposit amount must be positve .");
        }
    }
    public void withdraw(double amount){
        if (amount>0){
            Operation withdrawOperation=new Operation("withdraw",amount,new Date());
            addOperation(withdrawOperation);
            balance-=amount;
            System.out.println("Withdraw: "+ amount + " $ ");
            System.out.println("new Balance : "+ balance +" $ ");
        }else {
            System.out.println("withdraw amount must be positve .");
        }
    }
}

class Operation{
    private final String type;
    private final double amount;
    private final Date date;
    public Operation(String type, double amount, Date date){
        this.type=type;
        this.amount=amount;
        this.date=date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}























