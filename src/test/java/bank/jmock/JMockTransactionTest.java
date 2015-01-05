package bank.jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class JMockTransactionTest {
  Mockery context = new JUnit4Mockery();

  // Note, the following test is commented out as the classes under test have not yet been implemented.
  @Test
  public void transactionShouldDebitMoneyFromOneAccountAndCreditItToAnotherAccount() {
    /*
    // Note: Need to name the mock or jMock defaults to the classname and complains of duplicate definitions
    final Account sourceAccount = context.mock(Account.class, "sourceAccount");
    final Account destinationAccount = context.mock(Account.class, "destinationAccount");

    // Set expectations
    context.checking(new Expectations() {{
      oneOf(sourceAccount).debit(10);
      // etc...
    }});

    // Call the method to be tested on the class under test
    Transaction txn = new Transaction(sourceAccount, destinationAccount, 10);
    txn.execute();

    // JMock will automatically verify that all of the expectations have been met.
    // If any have not been met then the test will fail and JMock will report the cause of the failure.
    */
  }
}