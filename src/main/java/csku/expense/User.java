package csku.expense;

/**
 * Created by 708 on 8/31/2018.
 */
public class User {
    private String name;
    private IncomeAccount account;

    public User(String name){
        this.name = name;
        this.account = new IncomeAccount();
    }

    public String getName() {
        return name;
    }

    public IncomeAccount getAccount() {
        return account;
    }
}
