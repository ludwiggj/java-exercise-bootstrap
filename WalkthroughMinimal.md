# Walk through with Minimal Guidance

## Happy-path test case: A transaction should debit money from one account and credit to another account

Write a _happy-path_ test case for the Transaction class i.e.

**Given:** two accounts
**When:**  a transfer of an amount is requested
**Then:**  the _source_ account should be debited by the amount
**And:**   the _destination_ account should be credited by the amount

You should introduce an interface to represent an account, and a mock account class which implements that interface.

You should not create a production class to represent the account at this stage.

Regarding the mock accounts, think about what behaviour you'll need to mock. This will fall into two general categories:

* Instruct the mock to return a specific value when a particular method is called.
* Verify that a certain action has occurred e.g. the account has been debited by 10.

### Insufficient funds test case: The source account has insufficient funds

Write another test case for the Transaction class. In this scenario, the _source_ account has insufficient funds for the
requested transfer;

**Given:** two accounts
**When:**  a transfer of an amount is requested that is greater than the amount in the source account
**Then:**  an exception is thrown

Think about what type of exception you want to throw in this situation; checked or unchecked?

### Implement the account interface for real

Finally, write some tests for the production version of the account class, and use this to drive the creation of the
account production class.