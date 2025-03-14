package fintech.model;


import fintech.model.Account;
import java.util.ArrayList;
/**
 * @author 12S23036 Jopel Simarmata
 * @author 12S23024 Eska Silaen
 */
public class Transaction {

    private String accountName;
    private String amount;
    private String posted;
    private String note;
    public Integer i;

    Account DaftarAccount;

    public Transaction(Integer i,String accountName, String amount, String posted_at, String note){
        this.accountName = accountName;
        this.amount = amount;
        this.posted = posted_at;
        this.note = note;
        this.i = i;
        this.DaftarAccount = null;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }

    public String getPosted() {
        return posted;
    }

    public Double getBalances(Account account){
        return account.getBalance();
    }

    


    public void showTransaction(){
            System.out.println( this.i + "|" +this.accountName + "|" + this.amount + "|" + this.posted + "|" + this.note);


    }
    @Override
    public String toString(){
        return this.accountName + this.note + this.posted;
    }



}