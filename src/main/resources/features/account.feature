Feature: account
    As a user
    I want to add and view income and expense
    so that I know how much money I have

Scenario: Add Income.
    Given a user have income with detail from mom and balance 5000 exits
    When I add income with detail from mom and balance 1000 exitsm
    My balance is 6000

Scenario: Add Expense.
    Given a user have income with detail from mom and balance 1000 exits
    When I add expense with detail food and balance 100 exits
    My balance is 900

