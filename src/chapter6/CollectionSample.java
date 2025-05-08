package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSample {
  public static void main(String[] args) {
    // クラシカルな記法
    var l1 =
        new ArrayList<String>() {
          {
            add("apple");
            add("orange");
            add("banana");
          }
        };
    System.out.println(l1); // [apple, orange, banana]

    // List.of()で生成したリストはreadonlyだが、ArrayListでラップすることで変更可能になる
    var l2 = new ArrayList<String>(List.of("apple", "orange", "banana"));
    l2.add("strawberry");
    System.out.println(l2); // [apple, orange, banana, strawberry]

    // 拡張for
    for (var val : l2) {
      System.out.println(val);
    }
    // apple
    // orange
    // banana
    // strawberry

    // イテレータ
    var itr = l2.iterator(); // 最初、ポインタはコレクションの先頭を指す
    while (itr.hasNext()) { // 次の要素があるか確認
      System.out.println(itr.next()); // ポインタを次に移動・要素を取得
    }
    // apple
    // orange
    // banana
    // strawberry

    // リストを逆順に読み込むときには拡張forではなくイテレータを使う必要がある
    var itr2 = l2.listIterator(l2.size()); // 引数はイテレータの開始位置を指定
    while (itr2.hasPrevious()) {
      System.out.println(itr2.previous());
    }
    // strawberry
    // banana
    // orange
    // apple

    // 配列->リストに変換
    var arr3 = new String[] {"apple", "orange", "banana"};
    var l3 = Arrays.asList(arr3);
    System.out.println(l3); // [apple, orange, banana]
    l3.set(0, "strawberry"); // 配列にできる操作は可能
    System.out.println(l3); // [strawberry, orange, banana]
    // l3.add("strawberry"); // 配列にできない操作は不可
    System.out.println(Arrays.toString(arr3)); // [strawberry, orange, banana] 配列の内容も変わっている

    // 配列->リストに変換（コピー版）
    var arr4 = new String[] {"apple", "orange", "banana"};
    var l4 = new ArrayList<String>();
    Collections.addAll(l4, arr4);
    System.out.println(l4); // [strawberry, orange, banana]
    l4.set(0, "apple");
    l4.add("mango"); // 配列にできない操作も可能
    System.out.println(l4); // [apple, orange, banana, mango]
    System.out.println(Arrays.toString(arr4)); // [apple, orange, banana] 配列の内容は変わらず

    // 配列->リストに変換（Arrays.asListで生成したreadonlyリストをArrayListでラップする）
    var arr5 = new String[] {"apple", "orange", "banana"};
    var l5 = new ArrayList<String>(Arrays.asList(arr5));
    l5.add("strawberry"); // 配列にできない操作も可能
    System.out.println(l5); // [apple, orange, banana, strawberry]
    System.out.println(Arrays.toString(arr5)); // [apple, orange, banana] 配列の内容は変わらず

    // コレクション->配列に変換
    var l6 = new ArrayList<String>(List.of("apple", "orange", "banana"));
    var arr6 = new String[l6.size()]; // リストと同じサイズの配列を生成
    l6.toArray(arr6); // リストを配列に変換
    arr6[0] = "strawberry";
    l6.set(0, "cherry");
    System.out.println(Arrays.toString(arr6)); // [strawberry, orange, banana]
    System.out.println(l6); // [cherry, orange, banana]

    // 編集可能なリストをreadonlyに変更する
    var l7 =
        new ArrayList<String>() {
          {
            add("apple");
            add("orange");
            add("banana");
          }
        };
    var l8 = Collections.unmodifiableList(l7);
    // l8.add("strawberry"); // 不可
    // l8.set(0, "strawberry"); // 不可

    // 練習問題
    // ジェネリクスとは、メソッドなどで扱うデータの型の変数みたいなもの。メソッドを扱う側が、メソッドを利用するときに型の指定ができる。
    // コレクションでジェネリクスを使用するメリットは、型安全性と柔軟さの2点。
    // 柔軟さだけであれば、Object型を指定すれば良いが、型安全が担保されない。
    // 同様に、型安全だけであれば、型ごとにメソッドを作成すれば良いが、メソッドの量が莫大になり、作る側も使う側も大変。

    new ArrayList<Integer>(List.of(16, 24, 30, 39));
  }
}
