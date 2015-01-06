package bank;

public interface AccountLike {
  void debit(float amount);
  void credit(float amount);
  float getBalance();
}
