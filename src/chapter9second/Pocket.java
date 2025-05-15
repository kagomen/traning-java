package chapter9second;

import java.util.ArrayList;
import java.util.List;

// 2.2 ジェネリクス
public class Pocket<E> { // E: 仮型引数
  private E data;

  public void put(E data) {
    this.data = data;
  }

  public E get() {
    return this.data;
  }

  // ジェネリックメソッド
  // クラス以外にも、staticメソッドにジェネリクスを使用可能
  public static <T> List<T> asList(T... args) {
    List<T> list = new ArrayList<>();
    for (T arg : args) {
      list.add(arg);
    }
    return list;
  }

  public static void main(String[] args) {

    Pocket<String> p = new Pocket<>();

    p.put("1192");
    // p.put(1192); // コンパイルエラー

    System.out.println(p.get()); // キャスト不要

    // 型ワイルドカード
    Pocket<?> p2;
    p2 = new Pocket<String>();
    p2 = new Pocket<Integer>();

    // 継承の指定も可能
    Pocket<? extends Object> p3;

    var list = Pocket.asList("hello", "world");
    System.out.println(list); // [hello, world]

    var list2 = Pocket.asList(1, 2, 3);
    System.out.println(list2); // [1, 2, 3]
  }
}

/*
ジェネリクスの注意点:
- intなどの基本データ型は仮型引数に利用できない
  - ❌ Pocket<int>
- ジェネリクスを用いたクラスの配列を作ることはできない
  - ❌ ArrayList<String>[] list = new ArrayList<String>[10];
- Throwableの子孫クラス（例外クラス）はジェネリクスを使えない
*/

/*
ジェネリクスの制限:
public class Pocket<E extends Character>
とした場合、Characterクラスを継承する子孫クラスのみ、Pocketクラスの実型引数として指定可能になる
*/
