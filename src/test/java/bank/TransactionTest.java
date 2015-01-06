package bank;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {

  private static final float TRANSFER_AMOUNT = 10.0f;
  private MockAccount account1;
  private MockAccount account2;

  @Before
  public void setUp() throws Exception {
    account1 = new MockAccount();
    account2 = new MockAccount();
  }

  @Test
  public void transactionShouldDebitMoneyFromOneAccountAndCreditItToAnotherAccount() throws InsufficientFundsException {
    account1.whenGetBalanceIsCalledReturn(TRANSFER_AMOUNT);
    account1.expectDebit(TRANSFER_AMOUNT);
    account2.expectCredit(TRANSFER_AMOUNT);

    Transaction t = new Transaction(account1, account2, TRANSFER_AMOUNT);
    t.execute();

    account1.verify();
    account2.verify();
  }

  @Test(expected = InsufficientFundsException.class)
  public void transactionShouldFailIfFirstAccountHasInsufficientFunds() throws InsufficientFundsException {
    MockAccount poorAccount = new MockAccount();
    poorAccount.whenGetBalanceIsCalledReturn(0f);

    Transaction t = new Transaction(poorAccount, account2, TRANSFER_AMOUNT);
    t.execute();
  }
}