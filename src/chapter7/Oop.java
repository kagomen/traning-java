package chapter7;

import java.util.Optional;

public class Oop {

  // 練習問題
  public void hoge(int data) {
    if (data < 0) {
      data = 0;
    }
    System.out.println(data);
  }

  // フィールドはクラス内のトップレベルで宣言し、クラス全体で使用できる変数
  // ローカル変数はメソッド内やブロック内で宣言し、メソッド内・ブロック内で使用できる変数

  public String name;
  public int age;
  public int height;
  public int weight;

  public Oop(String name, int age, int height, int weight) {
    System.out.println("hello, " + name);
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }

  // public Oop() {
  //   // System.out.println("hello, " + name); // 不可。this()を使う場合は最初に宣言する必要がある
  //   this("no name", 0, 0, 0);
  //   System.out.println("hello, " + name);
  // }

  public double radius;

  public Oop(double radius) {
    this.radius = radius;
  }

  public Oop() {
    this(1);
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public static double getBmi(double weight, double height) {
    return weight / (height * height);
  }

  public static int getAverage(int... values) {
    int sum = 0;
    for (var val : values) {
      sum += val;
    }
    return sum / values.length;
  }

  public static void main(String[] args) {
    String val = null;
    var optVal = Optional.ofNullable(val);
    System.out.println(optVal); // Optional.empty
    System.out.println(optVal.orElse("non")); // non

    var title = optVal.orElse("non");
    title.trim();
  }

  // 理解度チェック
  // アクセス修飾子 protected private
  // static クラスメンバー
  // 定数 final
  // 可変長引数 ... 配列型

  // false protected
  // false メソッドならよい
  // false 重複した場合、フィールドはthisを使って呼び出す
  // false forブロックの中でのみ参照可能
  // true

  // String age this "権兵衛" 0 void printf

  // 100 100 100 10
}
