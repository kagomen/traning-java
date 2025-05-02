package chapter4;

public class LoopSample {
  public static void main(String[] args) {
    String[] fruits = {"apple", "orange", "strawberry"};
    for (final var val : fruits) {
      System.out.println(val);
    }

    for (final var val : args) {
      System.out.println(val);
    }

    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        System.out.print((i * j) + " ");
      }
      System.out.println();
    }

    int sum = 0;
    for (var i = 0; i <= 100; i++) {
      if (i % 2 != 0) {
        continue;
      }
      sum += i;
    }
    System.out.println("sum: " + sum);

    hoge:
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        int result = i * j;
        if (result > 50) {
          break hoge;
        }
        System.out.printf("%4d", result);
      }
      System.out.println();
    }

    System.out.println();

    /* 練習問題 */

    for (var val : args) {
      var i = Integer.parseInt(val);
      System.out.println(i * 1.5);
    }

    int sum2 = 0;
    for (var i = 100; i <= 200; i++) {
      if (i % 2 == 0) {
        continue;
      }
      sum2 += i;
    }
    System.out.println(sum2);

    String lang = "F#";
    String result =
        switch (lang) {
          case "Java", "Scala", "Kotlin" -> "JVM言語";
          case "C#", "VB", "F#" -> ".NET言語";
          default -> "不明";
        };
    System.out.println(result);

    switch (lang) {
      case "Java", "Scala", "Kotlin" -> System.out.println("JVM言語");
      case "C#", "VB", "F#" -> System.out.println(".NET言語");
      default -> System.out.println("不明");
    }

    if (lang.equals("Java") || lang.equals("Scala") || lang.equals("Kotlin")) {
      System.out.println("JVM言語");
    } else if (lang.equals("C#") || lang.equals("VB") || lang.equals("F#")) {
      System.out.println(".NET言語");
    } else {
      System.out.println("不明");
    }
  }
}
