package bank.jmock;

import bank.AccountLike;
import bank.InsufficientFundsException;
import bank.Transaction;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class JMockTransactionTest {
  public static final float TX_AMOUNT = 10.0f;
  Mockery context = new JUnit4Mockery();
  private AccountLike sourceAccount;
  private AccountLike destinationAccount;

  @Before
  public void setUp() {
    sourceAccount = context.mock(AccountLike.class, "sourceAccount");
    destinationAccount = context.mock(AccountLike.class, "destinationAccount");
  }

  // Note, the following test is commented out as the classes under test have not yet been implemented.
  @Test
  public void transactionShouldDebitMoneyFromOneAccountAndCreditItToAnotherAccount() throws Exception {
    context.checking(new Expectations() {{
      oneOf(sourceAccount).getBalance();
      will(returnValue(TX_AMOUNT));
      oneOf(sourceAccount).debit(TX_AMOUNT);
      oneOf(destinationAccount).credit(TX_AMOUNT);
    }});

    Transaction txn = new Transaction(sourceAccount, destinationAccount, TX_AMOUNT);
    txn.execute();
  }

  @Test(expected = InsufficientFundsException.class)
  public void transactionShouldFailIfFirstAccountHasInsufficientFunds() throws InsufficientFundsException {
    context.checking(new Expectations() {{
      oneOf(sourceAccount).getBalance();
      will(returnValue(0.0f));
    }});

    Transaction txn = new Transaction(sourceAccount, destinationAccount, TX_AMOUNT);
    txn.execute();
  }
}