package chapter8;

public class Child extends Parent {
  public Child(String name) {
    /*
    スーパークラスでデフォルトコンストラクタを指定していない場合、以下のエラーがサブクラスで発生する。

    Implicit super constructor Parent() is undefined. Must explicitly invoke another constructor
    暗黙のスーパーコンストラクタ Parent() は未定義です。明示的に別のコンストラクタを呼び出す必要があります。

    その場合、super(<スーパークラスで定義している引数>); を記述し、引数付きのコンストラクタを呼び出してやる必要がある
    super("kagome");
    */
    System.out.println("Child: " + name);
  }
}
