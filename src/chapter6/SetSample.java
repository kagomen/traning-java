package chapter6;

import java.util.HashSet;
import java.util.List;

public class SetSample {
  public static void main(String[] args) {
    var hs = new HashSet<Integer>(List.of(1, 20, 30, 10, 30, 60, 15));
    var hs2 = new HashSet<Integer>(List.of(10, 20, 99));

    System.out.println(hs); // [1, 20, 10, 60, 30, 15]
    System.out.println(hs.size()); // 6

    hs.addAll(hs2);
    System.out.println(hs); // [1, 99, 20, 10, 60, 30, 15] (和集合)

    hs.retainAll(hs2);
    System.out.println(hs); // [99, 20, 10] (積集合)

    var hs3 = new HashSet<Integer>(List.of(1, 10, 20));
    hs.removeAll(hs3);
    System.out.println(hs); // [99] (差集合)

    // 練習問題
    // セットはリストと違い、重複を許さない。
    // 集合の要素を持ち、包含を調査する場合、有効なコレクション。
    // HashSetは順序を持たない、TreeSet、LinkedSetは順序を持つ。
  }
}
