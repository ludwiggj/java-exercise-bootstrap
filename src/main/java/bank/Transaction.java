package bank;

public class Transaction {
  private final AccountLike from;
  private final AccountLike to;
  private final float amount;

  public Transaction(AccountLike from, AccountLike to, float amount) {
    this.from = from;
    this.to = to;
    this.amount = amount;
  }

  public void execute() throws InsufficientFundsException {
    float currentBalance = from.getBalance();
    if (amount > currentBalance) {
      throw new InsufficientFundsException(
          String.format("Cannot withdraw %f from account, only %f available.", amount, currentBalance)
      );
    }
    from.debit(amount);
    to.credit(amount);
  }
}