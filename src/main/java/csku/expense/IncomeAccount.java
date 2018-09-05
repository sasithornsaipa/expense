package csku.expense;

import java.util.ArrayList;

public class IncomeAccount {
    private ArrayList<ArrayList<String>> transaction;

    public IncomeAccount(){
        this.transaction = new ArrayList<ArrayList<String>>();
    }

    public void addTransaction(String t, String detail, String income){
        ArrayList<String> ls = new ArrayList<>();
        ls.add(t);
        ls.add(detail);
        ls.add(income);
        this.transaction.add(ls);
    }

    public Double getBalance(){
        Double balance = 0.0;
        for (ArrayList<String> i:transaction) {
            if (i.get(0) == "i"){
                balance += Double.parseDouble(i.get(2));
            }else {
                balance -= Double.parseDouble(i.get(2));
            }
        }
        return balance;
    }

    public ArrayList<ArrayList<String>> getTransaction() {
        return transaction;
    }
}
