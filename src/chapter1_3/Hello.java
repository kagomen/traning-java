package chapter1_3;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Hello {
  public static void main(String[] args) {
    LocalDateTime time = LocalDateTime.now();
    System.out.println(time);

    int i = 0b11;

    float f = 0.1f;
    double d = 0.1;
    double d2 = 1.32e1;

    char c = 'a';
    char c2 = 9;
    char c3 = '\u3042';

    var str = """
        hello
        hello \
        world""";
    System.out.println(str);

    long l = 12341123412341234L;
    // キャストしたらエディタでリントされなくなるので注意
    int i2 = (int)l;
    System.out.println(i2);

    final double DISCOUNT = 0.9;
    var price = 500;
    var sum = price * DISCOUNT;
    System.out.println((int)sum);

    var value = 10d;

    System.out.println("""
        ようこそ、
        Javaの世界へ！""");

    String string = null;

    int[][] data = new int[5][4];

    var list = new int[][]{
      {2,3,5},
      {1,2},
      {10,11,12,13},
    };

    var bd = new BigDecimal(0.7);
    System.out.println(bd); // -> 0.6999999999999999555910790149937383830547332763671875

    var bd2 = new BigDecimal("0.7");
    System.out.println(bd2); // -> 0.7

    var result = bd2.add(bd2);
    System.out.println(result); // -> 1.4

    final int[] ARRAY = {1,2,3};
    ARRAY[0] = 2;
    // ARRAY = {4,5,6};  // -> error

    final String str3 = "hello";
    // str3 = "world"; // -> error

    String str4 = "hi";
    var result2 = str4.equals(null) ? "値なし" : str4;
    System.out.println(str4);

    String nullStr = null;
    System.out.println(nullStr == null);

    System.out.println(nullStr);

    String str5 = null;
    // str5 = "hi";
    if(str5 != null && str5.endsWith(".java")){
      System.out.println("拡張子は.javaです");
    }
  }
}

