package chapter9second;

// 2.3 列挙型とstaticインポート
import static chapter9second.Type.FUTSU;
import static chapter9second.Type.TEIKI;

public class Account {
  private int number;
  private int amount;
  private Type type;

  public Account(int number, int amount, Type type) {
    this.number = number;
    this.amount = amount;
    this.type = type;
  }

  public static void main(String[] args) {
    new Account(1000, 10000, TEIKI);
    new Account(1000, 10000, FUTSU);
  }
}
