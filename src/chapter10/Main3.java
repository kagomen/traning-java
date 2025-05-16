package chapter10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class Main3 {
  public static boolean isOdd(int x) {
    return (x % 2 == 1);
  }

  public String passCheck(int point, String name) {
    return name + "さんは" + (point > 65 ? "合格" : "不合格");
  }

  @FunctionalInterface
  interface Func1 {
    boolean call(int x);
  }

  @FunctionalInterface
  interface Func2 {
    String call(int point, String name);
  }

  public static void main(String[] args) {
    // 宣言的なデータ処理を行うために、まずはストリームを生成する必要がある
    // コレクションの場合: Stream<T> st = <コレクション名><T>.stream();
    // 配列の場合: Stream<T> st = Arrays.stream(T型の配列);

    // 中間処理を終えたあと、collect()で終端処理を行う
    // collect(Collectors.toList());
    // collect(Collectors.toSet());

    Func1 f1 = Main3::isOdd;
    Func2 f2 = new Main3()::passCheck;

    Func1 f3 = (x) -> x % 2 == 1;
    Func2 f4 = (point, name) -> name + "さんは" + (point > 65 ? "合格" : "不合格");

    IntPredicate f5 = (x) -> x % 2 == 1;

    System.out.println(f1.call(10));
    System.out.println(f2.call(80, "kagome"));

    List<String> names = List.of("菅原拓真", "湊雄介", "浅香あゆみ", "大江岳斗");
    names.stream().filter(p -> p.length() <= 4).forEach(p -> System.out.println(p + "さん"));

    // (i) -> i*i;

    var list = new ArrayList<String>(List.of("kitahara", "akutagawa", "mishima"));
    list.removeIf(item -> item.length() > 8);
    System.out.println(list);
  }
}
