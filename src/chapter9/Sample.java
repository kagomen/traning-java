package chapter9;

import java.util.Objects;

public class Sample {
  public static void main(String[] args) {

    class MyIntClass {
      int value;

      MyIntClass(int value) {
        this.value = value;
      }
    }

    var a = new MyIntClass(100);
    MyIntClass b = new MyIntClass(100);

    System.out.println(a.equals(b)); // false
    // デフォルトのequals()は==と同じで、同一性を確認する挙動をとる
    // 本来のequals()は同値性を確認するものなので、オーバーライドする必要がある

    System.out.println(Objects.equals(a.value, b.value)); // true

    // a.value.equals();

    class MyStringClass {
      String value;

      MyStringClass(String value) {
        this.value = value;
      }
    }

    var c = new MyStringClass("hello");
    var d = new MyStringClass("hello");

    System.out.println(c.equals(d)); // false
    System.out.println(Objects.equals(c.value, d.value)); // true
    System.out.println(c.value.equals(d.value)); // false
  }
}
