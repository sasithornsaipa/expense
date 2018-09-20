Feature: account
         As a user I want to add and view income and expense
         so that I know how much money I have

Scenario: Add Income.
    Given a user have income with detail mom and balance 5000 exits
    When I add income with detail from mom and balance 1000 exits
    Then My balance is 6000

Scenario: Add Expense.
    Given a user have income with detail mom and balance 1000 exits
    When I add expense with detail food and balance 100 exits
    Then My balance is 900

Scenario: Edit Expense.
    Given a user have income from mom and balance 1000 and expense with detail food and balance 100 exits
    When I edit expense at index 1 change to 50 exits
    Then My balance is 950

