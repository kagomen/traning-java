package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// #compareTo(), Comparable, Comparator, Collections.sort()
public class BankAccount implements Comparable<BankAccount> {
  int number; // 口座番号
  int amount; // 残高

  public BankAccount(int number, int amount) {
    this.number = number;
    this.amount = amount;
  }

  // 口座番号以外のフィールドで比較することも可能だが、compareToで指定できるのはひとつだけ（自然順序）
  // もし複数の要素で比較したい場合は、Comparatorを使う->AmountComparatorを参照
  @Override
  public int compareTo(BankAccount obj) {
    if (this.number < obj.number) return -1;
    if (this.number > obj.number) return 1;
    return 0; // 等しければ0
  }

  @Override
  public String toString() {
    return "[口座番号: " + this.number + ", 残高: " + this.amount + "]";
  }

  // 1つのクラスに#equals()と#compareTo()を実装する場合、
  // equals()でtrueが返る2つのインスタンスは、compareTo()で比較した場合、
  // 必ず0が返る、という一貫性を保つこと
  // 一貫性が保たれていない場合、TreeSetなど一部のAPIで想定外の動作をする恐れがある（BigIntegerやBigDecimalはequals()とcompareTo()に一貫性がないことで有名）
  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (!(obj instanceof BankAccount)) return false;
    BankAccount r = (BankAccount) obj;
    if (this.number == r.number) return true;
    return false;
  }

  public static void main(String[] args) {
    List<BankAccount> list = new ArrayList<>();
    list.add(new BankAccount(1001, 9000));
    list.add(new BankAccount(1002, 8000));
    list.add(new BankAccount(1000, 10000));

    System.out.println(list);
    // [[口座番号: 1001, 残高: 9000], [口座番号: 1002, 残高: 8000], [口座番号: 1000, 残高: 10000]]

    Collections.sort(list); // 口座番号順にソート
    // もし#compareTo()をオーバーライドしていない場合、以下のエラーが発生する。
    // The method sort(List<T>) in the type Collections is not applicable for the arguments
    // (List<BankAccount>)Java(67108979)
    // Collections型のメソッドsort(List<T>)は、引数(List<BankAccount>)には適用できません。Java(67108979)

    System.out.println(list);
    // [[口座番号: 1000, 残高: 10000], [口座番号: 1001, 残高: 9000], [口座番号: 1002, 残高: 8000]]

    Collections.sort(list, new AmountComparator()); // 残高順にソート
    System.out.println(list);
    // [[口座番号: 1002, 残高: 8000], [口座番号: 1001, 残高: 9000], [口座番号: 1000, 残高: 10000]]
  }
}
