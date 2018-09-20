package csku.expense;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefExpenseApp {
    IncomeAccount account;

    @Before
    public void init(){
        account = new IncomeAccount();
    }



    @Given("a user have income with detail (.*) and balance (.*) exits")
    public void a_user_have_income_with_detail_and_balance_exits(String detail,double income){
        account.addTransaction("i", detail, income+"");
    }
    @Given("^a user have income from mom and balance (\\d+) and expense with detail food and balance (\\d+) exits$")
    public void a_user_have_income_from_mom_and_balance_and_expense_with_detail_food_and_balance_exits(int income, int expense){
        account.addTransaction("i", "mom", income+"");
        account.addTransaction("e", "food", expense+"");
    }

    @When("I add income with detail (.*) and balance (.*) exits")
    public void I_add_income_with_detail_and_balance_exits(String detail,String income){
        account.addTransaction("i", detail, income);
    }

    @When("I add expense with detail (.*) and balance (.*) exits")
    public void I_add_expense_with_detail_and_balance_exits(String detail,String income){
        account.addTransaction("e", detail, income);
    }

    @When("I edit expense at index (.*) change to (.*) exits")
    public void I_add_expense_with_detail_and_balance_exits(int index,String newValue){
        account.editTransaction(index, newValue);
    }

    @Then("My balance is (.*)")
    public void My_balance_is(double balance){
        assertEquals(balance, account.getBalance().doubleValue());
    }
}
