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

    @When("I add income with detail (.*) and balance (.*) exits")
    public void I_add_income_with_detail_and_balance_exits(String detail,String income){
        account.addTransaction("i", detail, income);
    }

    @When("I add expense with detail (.*) and balance (.*) exits")
    public void I_add_expense_with_detail_and_balance_exits(String detail,String income){
        account.addTransaction("e", detail, income);
    }

    @Then("My balance is (.*)")
    public void My_balance_is(double balance){
        assertEquals(balance, account.getBalance().doubleValue());
    }
}
