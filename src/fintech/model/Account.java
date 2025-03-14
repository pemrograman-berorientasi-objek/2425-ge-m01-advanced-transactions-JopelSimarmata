package fintech.model;

import java.util.ArrayList;

import fintech.model.Transaction;


/**
 * @author 12S23036 Jopel Simarmata
 * @author 12S23024 Eska Silaen
 */
public class Account {


    private String owner,accountName;
    private double balance = 0.0;

    ArrayList<Transaction> DaftarTransaction;

    public Account(String owner, String accountName){
        this.owner = owner;
        this.accountName = accountName;
        this.DaftarTransaction = new ArrayList<>();

        System.out.println(this.accountName + "|" + this.owner + "|" + this.balance);
        
        
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setTransaction(Transaction taransaksi){
        this.DaftarTransaction.add(taransaksi);
    }




    public void displayAccount(){
        Double jumlah = 0.0;
        for(int i = 0 ; i < DaftarTransaction.size(); i++){
            jumlah = jumlah + Double.parseDouble(DaftarTransaction.get(i).getAmount());
        }
        this.balance = jumlah;
        if(this.balance < 0){
            this.balance = 0.0;
        }
        System.out.println(this.accountName + "|" + this.owner + "|" + this.balance);
    }








}