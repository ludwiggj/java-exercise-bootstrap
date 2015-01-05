# Walk through with Step by Step Guidance

The following is a step by step walk through of how to complete the kata.

## Happy-path test case: A transaction should debit money from one account and credit to another account

The test is as follows;

**Given:** two accounts
**When:**  a transfer of an amount is requested
**Then:**  the _source_ account should be debited by the amount
**And:**   the _destination_ account should be credited by the amount


---------------------------------------

* Create a new test class **TransactionTest** and a new test to the class.
* Instantiate a new Transaction instance inside the test with no parameters. **(RED: compile fails)**
* Use the IDE to create a new production class for Transaction. **(GREEN: compiles)**

---------------------------------------

* Create two mock instances of Account called **account1** and **account2** inside the test. These are both instances of
  a new class **MockAccount**, which implements a new **Account** interface. **(RED: compile fails)**
* **NOTE**: account1 and account2 correspond to the source and destination accounts of the transaction
  respectively.
* Use the IDE to create the Account interface. **(GREEN: compiles)**

---------------------------------------

* Add parameters to the Transaction constructor (account1, account2, float amount). **(RED: compile fails)**
* Use the IDE to change the Transaction constructor to meet the new signature. **(GREEN: compiles)**

---------------------------------------

* Add a call to the Transaction instance execute() method inside the test. **(RED: compile fails)**
* Use the IDE to generate the new execute() method on Transaction. **(GREEN: compiles)**

---------------------------------------

* Add an _expectation_ method expectDebit() to **account1** to indicate that the account expects to receive a debit
  request for a specific **amount**. **(RED: compile fails)**
* Use the IDE to generate the expectDebit() method on MockAccount. **(GREEN: compiles)**
* Use the IDE to add a debit() method to the account interface. **(RED: compile fails)**
* Use the IDE to generate the debit() method on MockAccount. **(GREEN: compiles)**

---------------------------------------

* Add a verify() method on MockAccount, and implement it. It should check that if the expectDebit() method has been
  called with value x, then the debit() method has also been called on MockAccount with the same value.
  **(GREEN: compiles)**
* Add a call to account1.verify() in the test. **(RED: test fails, mock expectations not met)**
* Write code in Transaction.execute() to pass the test. **(GREEN: test passes)**

---------------------------------------

* Add an _expectation_ method expectCredit() to **account2** to indicate that the account expects to receive a credit
  request for the same amount debited from account1. **(RED: compile fails)**
* Use the IDE to generate the expectCredit() method on MockAccount. **(GREEN: compiles)**
* Use the IDE to add a credit() method to the account interface. **(RED: compile fails)**
* Use the IDE to generate the credit() method on MockAccount. **(GREEN: compiles)**

---------------------------------------

* Modify the MockAccount.verify() method. It should also check that if the expectCredit() method has been called with
  value x, then the credit() method has also been called on MockAccount with the same value. **(GREEN: compiles)**
* Add a call to account2.verify() in the test. **(RED: test fails, mock expectations not met)**
* Write code in Transaction.execute() to pass the test. **(GREEN: test passes)**


## Insufficient funds test case: The source account has insufficient funds

The test is as follows;

**Given:** two accounts
**When:**  a transfer of an amount is requested that is greater than the amount in the source account
**Then:**  an exception is thrown

---------------------------------------

* Add a new test to class **TransactionTest**.
* Add the @Expected annotation with the appropriate exception. Think about what type of exception you want to throw in
  this scenario; checked or unchecked? **(RED: single test fails, expected exception not thrown)**

---------------------------------------

* Create a new mock instance **poorAccount** in the test. **(RED: single test fails, expected exception not thrown)**
* Add the expectation that when poorAccount.balance() is called it returns 0. **(RED: compile fails)**
* Use the IDE to add a balance method to the account interface and mock account.
  **(RED: single test fails, expected exception not thrown)**

---------------------------------------

* Create a new mock instance **account2** in the test with no expected method calls.
  **(RED: single test fails, expected exception not thrown)**
* Create a new instance of Transaction in the test, passing in (poorAccount, account2, 10).
  **(RED: single test fails, expected exception not thrown)**
* Add a call to the Transaction instance execute() method. **(RED: single test fails, expected exception not thrown)**

---------------------------------------

* Add code to Transaction.execute() to check the balance of the source account, but do nothing with the result.
  **(RED: two tests fail)**
* Add an expectation to first test that when balance() is called it returns an amount greater than the requested
  withdrawal amount. **(RED: single test fails, expected exception not thrown)**
* Add code to Transaction.execute() to throw the appropriate exception if the balance is insufficient.
  **(GREEN: tests pass)**

---------------------------------------

## Implement the Account interface for real

Use TDD with assertions.

* Create a new test class for Account.
* Add a new test: When debit is called on the account the balance should drop by the correct amount. Get the test to
  pass.
* Add a new test: When credit is called the balance should increase by the correct amount. Get the test to pass.