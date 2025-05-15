package chapter9second;

public class Outer {
  public static String staticOuterField;
  public String outerField;

  public void outerMethod() {
    var si = new StaticInner();

    class LocalInner {
      public void localInnerMethod() {
        System.out.println("Local Inner Method");
      }
    }
    LocalInner li = new LocalInner();
    li.localInnerMethod();
  }

  public static class StaticInner {
    void staticInnerMethod() {
      // outerField = "unenable"; // アウタークラスのフィールドにはアクセスできない
      staticOuterField = "Static Outer Field"; // staticフィールドならアクセス可能
    }
  }

  public class Inner {}

  public static void main(String[] args) {
    Outer.StaticInner si = new Outer.StaticInner();
    Outer.Inner i = new Outer().new Inner();

    Outer o = new Outer();
    o.outerMethod();

    // 匿名クラスは親を呼び出す
    var obj =
        new Object() {
          void greet() {
            System.out.println("Hello!");
          }
        };
    obj.greet();
  }
}

/*
 * インナークラスの種類
 * - メンバクラス
 *  - static
 *  - 非static
 * - ローカルクラス（メソッドブロック内で宣言されるクラス）
 * - 匿名クラス
 */
