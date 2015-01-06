package bank;

import java.util.ArrayList;
import java.util.List;

import static bank.AccountEvent.aCreditFor;
import static bank.AccountEvent.aDebitFor;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MockAccount implements AccountLike {
  private List<AccountEvent> expectedEvents = new ArrayList<AccountEvent>();
  private List<AccountEvent> actualEvents = new ArrayList<AccountEvent>();
  private float mockedBalance;

  public void expectDebit(float txAmount) {
    expectedEvents.add(aDebitFor(txAmount));
  }

  public void expectCredit(float txAmount) {
    expectedEvents.add(aCreditFor(txAmount));
  }

  public void whenGetBalanceIsCalledReturn(float balance) {
    mockedBalance = balance;
  }

  public void verify() {
    assertThat(actualEvents, equalTo(expectedEvents));
  }

  @Override
  public void debit(float amount) {
    actualEvents.add(aDebitFor(amount));
  }

  @Override
  public void credit(float amount) {
    actualEvents.add(aCreditFor(amount));
  }

  @Override
  public float getBalance() {
    return mockedBalance;
  }
}