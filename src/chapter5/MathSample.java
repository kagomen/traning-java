package chapter5;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Random;

public class MathSample {
  public static void main(String[] args) {
    System.out.println(Math.abs(-100));
    System.out.println(Math.round(123.45));
    System.out.println(Math.round(123.54));

    // long型を超える数値を扱う場合
    var result = BigInteger.valueOf(5); // 引数には初期値を指定
    for (var i = 1; i < 26; i++) {
      result = result.multiply(BigInteger.valueOf(i));
      System.out.println(result);
    }
    // 広範囲な浮動小数点を扱う場合はBigDecimalクラスを利用する

    // 乱数
    var random = new Random();
    System.out.println(random.nextInt(5) + 1);

    // 数値のフォーマット
    var nf = NumberFormat.getPercentInstance();
    System.out.println(nf.format(123.56)); // ->12,356%
  }
}
