package fintech.driver;
import java.util.Scanner;
import java.util.ArrayList;
import fintech.model.Account;
import fintech.model.Transaction;

/**
 * @author 12S23036 Jopel Simarmata
 * @author 12S23024 Eska Silaen
 */
public class Driver1 {

    public static void main(String[] _args) {
        Scanner scn = new Scanner(System.in);
        Integer index = 1;

        ArrayList<Account> DaftarAccount = new ArrayList<>();
        ArrayList<Account> DaftarAccount2 = new ArrayList<>();
        ArrayList<Transaction> DaftarTransaction = new ArrayList<>();
        ArrayList<Integer> ListPrint = new ArrayList<>();

        while(true){
            String command = scn.nextLine();

            if(command.equalsIgnoreCase("---")){
                break;
            }
            String[] splitcommand = command.split("#");
            String[] temp = new String[5];

            temp[0] = splitcommand[0];

            if (temp[0].equals("show-account")){

                temp[1] = splitcommand[1];

                sortTransactionsByDate(DaftarTransaction);
                for(int i = 0; i < DaftarAccount.size();i++){
                    
                    DaftarAccount.get(i).displayAccount();
                    if(DaftarAccount.get(i).getAccountName().equals(temp[1])){
                        for(int j = 0; j < DaftarTransaction.size(); j++){
                            if(temp[1].equals(DaftarTransaction.get(j).getAccountName())){
                            if(DaftarAccount.get(i).getBalance() >0 ){
                                DaftarTransaction.get(j).showTransaction();
                            }
                        }
                        }
                        
                    }
                    
                }
                



            } else if(temp[0].equals("create-account")){
                temp[1] = splitcommand[1];
                temp[2] = splitcommand[2];
                Account account = new Account(temp[1],temp[2]);

                DaftarAccount.add(account);

                
            
            } 
            
            if (temp[0].equals("create-transaction")){

                temp[1] = splitcommand[1];
                temp[2] = splitcommand[2];
                temp[3] = splitcommand[3];
                temp[4] = splitcommand[4];

                
                Transaction transaksi = new Transaction(index,temp[1],temp[2],temp[3],temp[4]);
                DaftarTransaction.add(transaksi);
            

                for(int i = 0; i < DaftarAccount.size(); i++){
                    if(DaftarAccount.get(i).getAccountName().equals(temp[1])){
                        DaftarAccount.get(i).setTransaction(transaksi);
                    }
                }




                index++;

            } else if(temp[0].equals("show-accounts")) {

                sortTransactionsByDate(DaftarTransaction);
                for(int i = 0; i < DaftarAccount.size(); i++){
                    DaftarAccount.get(i).displayAccount();
                    for(int j = 0; j < DaftarTransaction.size(); j++){
                        if(DaftarAccount.get(i).getAccountName().equals(DaftarTransaction.get(j).getAccountName())){
                        if(DaftarAccount.get(i).getBalance() >0 ){
                            DaftarTransaction.get(j).showTransaction();
                        }
                    }
                    }
                }

            }
        }





        

        

    }

    public static void sortTransactionsByDate(ArrayList<Transaction> transactions) {
        transactions.sort((t1, t2) -> t1.getPosted().compareTo(t2.getPosted()));
    }

}