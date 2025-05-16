package chapter10;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
  public static Integer len(String s) {
    return s.length();
  }

  public Integer len2(String s) {
    return s.length();
  }

  public static boolean bl(String s) {
    return s.length() > 0;
  }

  // 標準関数インターフェースだけで補えない場合は、オリジナル関数インターフェースを作成する
  @FunctionalInterface
  public interface MyConsumer {
    public abstract void process(String a, String b, String c);
  }

  public static void main(String[] args) {
    // Function<引数の型, 戻り値の型>
    Function<String, Integer> func = Main::len; // staticメソッドの場合
    System.out.println(func.apply("Java")); // 4

    Function<String, Integer> func2 = new Main()::len2; // インスタンスメソッドの場合
    System.out.println(func2.apply("SpringBoot")); // 10

    // Consumer<引数の型>（戻り値なし）
    Consumer<String> func3 = System.out::println;

    // Supplier<戻り値の型>（引数なし）
    Supplier<String> func4 = System::lineSeparator;

    // BiFunction<引数の型, 引数の型, 戻り値の型>（引数が2つ, 戻り値が1つある）
    BiFunction<String, String, String> func5 = System::getProperty;

    // Predicate<引数の型>（引数が1つ, 戻り値はboolean）
    Predicate<String> func6 = Main::bl;
  }
}
