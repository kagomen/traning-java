package chapter9second;

import java.util.Collection;

public class Dog {
  public String name;
  public Object obj;

  public Dog(String name) {
    this.name = name;
    this.name = "John";
  }

  public static <T> boolean addAll(Collection<? super T> c, T... elements) {
    boolean result = false;
    for (var el : elements) {
      result |= c.add(el);
    }
    return result;
  }

  public static void main(String[] args) {
    String taro = "Taro"; // メモリに"Taro"という文字列が作成され、taroがそれを参照する
    Dog dog = new Dog(taro); // taroの値である"Taro"が渡される（値渡し）

    System.out.println(dog.name); // John
    System.out.println(taro); // Taro

    for (var d : Weekday.values()) {
      System.out.println(d.ordinal() + ":" + d.name());
    }
  }
}
