package chapter5;

import java.util.Arrays;

public class ArraysSample {
  public static void main(String[] args) {
    var arr1 = new String[] {"dog", "cat", "mouse", "fox", "lion"};
    Arrays.sort(arr1);
    System.out.println(Arrays.toString(arr1)); // [cat, dog, fox, lion, mouse]

    var arr2 = Arrays.copyOf(arr1, 2);
    System.out.println(Arrays.toString(arr2)); // [cat, dog]

    var arr3 = Arrays.copyOfRange(arr1, 2, 4);
    System.out.println(Arrays.toString(arr3)); // [fox, lion]

    Arrays.fill(arr1, 3, 5, "cat"); // [cat, dog, fox, cat, cat]
    System.out.println(Arrays.toString(arr1));

    var list1 =
        new StringBuilder[] {
          new StringBuilder("ABC"), new StringBuilder("DEF"), new StringBuilder("GHI")
        };
    // シャローコピー（アドレスをコピー）
    var list2 = Arrays.copyOf(list1, list1.length);
    list1[2].append("JKL");
    System.out.println(Arrays.toString(list1)); // [ABC, DEF, GHIJKL]
    System.out.println(Arrays.toString(list2)); // [ABC, DEF, GHIJKL]

    // ディープコピー（要素をコピー）
    var list3 = new StringBuilder[list1.length];
    for (var i = 0; i < list1.length; i++) {
      list3[i] = new StringBuilder(list1[i].toString());
    }
    list1[2].append("JKLMNO");
    System.out.println(Arrays.toString(list1)); // [ABC, DEF, GHIJKLJKLMNO]
    System.out.println(Arrays.toString(list3)); // [ABC, DEF, GHIJKL]
  }
}
