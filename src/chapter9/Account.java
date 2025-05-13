package chapter9;

// 1.3.2 #equals()のオーバーライド
public class Account {
  String accountNumber;
  public int number;

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true; // 自分自身が引数に渡されたら無条件でtrue
    if (obj == null) return false; // nullが引数に渡されたら無条件でfalse
    if (!(obj instanceof Account)) return false; // 型が違えばfalse
    Account r = (Account) obj; // 次の検証に備え、キャスト
    if (this.accountNumber.equals(r.accountNumber)) {
      return true; // フィールドを比較し、同値であればtrue(String.equals()は同値を検証する)
    }
    return false;
  }
}
