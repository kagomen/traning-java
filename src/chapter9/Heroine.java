package chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// 1.4.1 コレクションクラスの#equals()
public class Heroine {
  String name;

  public Heroine(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (!(obj instanceof Heroine)) return false;
    Heroine r = (Heroine) obj;
    if (this.name.equals(r.name)) return true;
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name); // クラスのフィールドをすべて引数として渡すことが多い
  }

  public static void main(String[] args) {
    // ======= ArrayListの例 =========
    List<Heroine> list = new ArrayList<>();

    Heroine kagome = new Heroine("kagome");
    list.add(kagome);

    kagome = new Heroine("kagome");

    list.remove(kagome);
    System.out.println(list.size());
    // Heroine#equals()をオーバーライドしない場合、1
    // Heroine#equals()をオーバーライドした場合、0

    // ======= HashSetの例 =========
    Set<Heroine> set = new HashSet<>();

    Heroine uri = new Heroine("uri");
    set.add(uri);

    uri = new Heroine("uri");

    set.remove(uri);
    System.out.println(set.size());
    // Heroine#equals()をオーバーライドしているが、Heroine#hashCode()をオーバーライドしていない場合: 1
    // Heroine#equals()もHeroine#hashCode()もオーバーライドしている場合: 0

    // HashSetは①まずハッシュ値を確認し、ハッシュ値が同じであれば②#equals()で判定を行う。

    // 同値ならハッシュ値は必ず同じ。
    // 同値でない場合、ハッシュ値は通常異なるが、稀に同じになることもある。

    // ======= まとめ =========
    // ArrayList:
    // #equals()を使って 線形探索 で要素を確認する
    // 要素数が n の場合、検索の計算量は O(n)
    // リスト内の各要素に対して1つずつ比較するため、要素数が多いと遅くなる

    // HashSet:
    // まず#hashCode()で高速にバケットを特定する（O(1)）
    // 同じハッシュ値を持つ要素だけに対して#equals()を使って同値確認をする
    // ハッシュ関数が適切に分散していれば、計算量は平均 O(1)
    // 最悪の場合（全要素が同じハッシュ値）はO(n)になるが普通はならない

    // メモリ使用量:
    // HashSetはハッシュテーブルを維持するため、ArrayListより多くのメモリを使う

    // 選択基準:
    // 検索や重複チェックが頻繁: HashSetを使用
    // 順序の保存や要素へのインデックスアクセスが必要: ArrayListを使用
    // メモリが制限されている場合: 操作の頻度を考慮して選択
  }
}
