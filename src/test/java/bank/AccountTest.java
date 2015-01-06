package bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
  private static final float ACCOUNT_BALANCE = 10;
  private Account account;

  @Before
  public void setUp() {
    account = new Account(ACCOUNT_BALANCE);
  }

  @Test
  public void debitShouldDecreaseAccountBalanceByDebitedAmount() {
    float debitAmount = 5;
    account.debit(5);
    assertThat(account.getBalance(), is(ACCOUNT_BALANCE - debitAmount));
  }

  @Test
  public void creditShouldIncreaseAccountBalanceByCreditedAmount() {
    float creditAmount = 5;
    account.credit(5);
    assertThat(account.getBalance(), is(ACCOUNT_BALANCE + creditAmount));
  }
}
