package chapter10.practice;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

  @FunctionalInterface
  public interface Hoge {
    void print(String str);
  }

  @FunctionalInterface
  public interface Foo<T, R> {
    R process(T v1, T v2);
  }

  public static void main(String[] args) {
    var list = List.of("ABCDE", "OP", "WXYZ", "HIJKL");

    var trimmedList =
        list.stream().filter(v -> v.length() > 3).map(v -> v.substring(0, 3)).toList();
    System.out.println(trimmedList);
    // [ABC, WXY, HIJ]

    var trimmedList2 = list.stream().map(v -> v.length() > 3 ? v.substring(0, 3) : v).toList();
    System.out.println(trimmedList2);
    // [ABC, OP, WXY, HIJ]

    var sweets = List.of("シュークリーム", "プリン", "マドレーヌ", "ババロア");
    sweets.stream().sorted((x, y) -> y.length() - x.length()).forEach(System.out::println);

    var scores =
        IntStream.of(60, 95, 75, 80, 70)
            .collect(
                IntSummaryStatistics::new,
                IntSummaryStatistics::accept,
                IntSummaryStatistics::combine);
    System.out.println(scores.getMax());
    System.out.println(scores.getAverage());
  }
}
