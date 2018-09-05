package csku.expense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTestIncomeAccount {

    IncomeAccount account;
    @BeforeEach
    void init() {
        account = new IncomeAccount();
        account.addTransaction("i", "from mom", "5000");
    }

    @Test
    void testAddIncome(){
        account.addTransaction("i", "from mom", "1000");
        assertEquals(6000, account.getBalance().doubleValue());
    }

    @Test
    void testAddExpense(){
        account.addTransaction("e", "food", "100");
        assertEquals(4900.0, account.getBalance().doubleValue());
    }

}
