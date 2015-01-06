package bank;

public class AccountEvent {
  private Action action;
  private float amount;

  public static AccountEvent aDebitFor(float amount) {
    return new AccountEvent(Action.DEBIT, amount);
  }

  public static AccountEvent aCreditFor(float amount) {
    return new AccountEvent(Action.CREDIT, amount);
  }

  private AccountEvent(Action action, float amount) {
    this.action = action;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AccountEvent that = (AccountEvent) o;

    if (Float.compare(that.amount, amount) != 0) return false;
    if (action != that.action) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = action.hashCode();
    result = 31 * result + (amount != +0.0f ? Float.floatToIntBits(amount) : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ActionAmount{" +
        "action=" + action +
        ", amount=" + amount +
        '}';
  }
}

enum Action {
  CREDIT, DEBIT
}
