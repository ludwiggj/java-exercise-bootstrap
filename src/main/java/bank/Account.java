package bank;

public class Account implements AccountLike {
  private float balance;

  public Account(float initialBalance) {
    balance = initialBalance;
  }

  @Override
  public void debit(float amount) {
    balance -= amount;
  }

  @Override
  public void credit(float amount) {
    balance += amount;
  }

  @Override
  public float getBalance() {
    return balance;
  }
}
