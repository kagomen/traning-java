package chapter9;

import java.util.Arrays;

// 1.3.4 配列の#equals()
public class ArraySample {
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {1, 2, 3, 4, 5};

    // 多くの標準APIクラスは#equals()を適切にオーバーライドしているため、
    // #equals()を使って同値判定が可能。
    // しかし、配列はオーバーライドしていないため、
    // Array#equals()はデフォルトの同一判定が行われる。
    System.out.println(arr1.equals(arr2)); // false

    // 配列の同値判定をする場合は、Arrays.equals()を使用する。
    System.out.println(Arrays.equals(arr1, arr2)); // true

    int[][] arr3 = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    int[][] arr4 = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    // 多次元配列の同値判定を行う場合はArrays.deepEquals()を使用する。
    System.out.println(Arrays.equals(arr3, arr4)); // false
    System.out.println(Arrays.deepEquals(arr3, arr4)); // true
  }
}
// Array#equals(): Arrayクラスのインスタンスメソッドであるequals()
// Arrays.equals(): Arraysクラスのクラスメソッドであるequals()
