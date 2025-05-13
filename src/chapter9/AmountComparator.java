package chapter9;

import java.util.Comparator;

public class AmountComparator implements Comparator<BankAccount> {
  public int compare(BankAccount x, BankAccount y) {
    return (x.amount - y.amount);
  }
}
