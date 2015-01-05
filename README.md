# Bank Account Transfer Kata

This is a simple kata illustrating behaviour driven development and the use of mock objects.

## Background

The problem to be solved is to model a bank account transfer between two accounts. This is called a _Transaction_.
A client system will create a new transaction specifying the source account, destination account and an amount of money
to be transferred between the accounts.

We will focus on the following two scenarios:

1. The happy-path case; money will be deducted from the source account and credited to the destination account.

2. An error scenario where the source account has insufficient funds; the transaction will fail with a
   descriptive exception.

## Mocking the Expected Behaviour

The production code you will write for a transaction will interact with Account objects that represent the source and
destination accounts.

There are several approaches we could use to model the account objects. In this kata, we will represent the accounts
using _test doubles_. This will allow us to write and test the Transaction code before the Account code is developed.


There are several mocking libraries you can use to create the test doubles. However, for this exercise, you are going to
write your own test doubles from scratch, without using a mocking library.

## How to start the Kata

If you are reasonably comfortable with the idea of writing your own test doubles, and using TDD to drive the solution
via tests, then have a go at solving the problem using the information in the file **WalkthroughMinimal.md**.

If you would then like more detailed _step by step_ guidance to help solve the problem, please follow the instructions
in **WalkthroughStepByStep.md**.

## Extension: JMock

Now we'll look at writing the same tests, but using JMock, which is a mocking library. You should hopefully recognise
some of the features that JMock provides based on writing your own mock classes in the previous exercise.

First look at the JMockExampleTest class. It has two tests, failingTest and passingTest. The failing test is ignored,
which means that it will be executed when running all the tests in the class . To run it you must first comment out the
@Ignore annotation that precedes the test. Note that the failing test fails not because it the compare method returns
the wrong result (it actually returns the right result), but because the mock was not called in the expected manner.

Once you have looked at the example, you can have a go at rewriting the previous tests using JMock. See the docs
directory for a helpful JMock cheat sheet.

If you are still puzzled take a look at the JMockTransactionTest class, which will point you in the right direction.
You'll need to uncomment the code first.

END.