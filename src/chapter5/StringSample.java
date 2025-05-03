package chapter5;

import java.time.LocalDateTime;

public class StringSample {
  public static void main(String[] args) {

    String s = "ABCあいう";
    System.out.println(s.length()); // 6

    String s2 = "𠮷野家"; // "𠮷"はサロゲートペア
    System.out.println(s2.length()); // 4
    System.out.println(s2.codePointCount(0, s2.length())); // 3

    String s3 = "😻";
    System.out.println(s3.length()); // 2
    System.out.println(s3.codePointCount(0, s3.length())); // 1

    // ストリームとして処理
    String s4 = "Spring🌸";
    System.out.println(s4.codePoints().count()); // 7

    System.out.println("A\ra"); // キャリッジリターン：先頭に戻す
    // a
    System.out.println("B\nb"); // ラインフィード：改行
    // B
    // b
    System.out.println("C\fc"); // フォームフィード：ページ送り
    // C
    //  c
    // （空白でページ送りが表現されている）

    var str = "にわにはにわにわとりがいる";
    System.out.println(str.indexOf("にわ")); // 0
    System.out.println(str.indexOf("にも")); // -1
    System.out.println(str.lastIndexOf("にわ")); // 6

    var str2 = "ABCプロジェクト";
    System.out.println(str2.contains("プロ"));
    System.out.println(str2.startsWith("A"));

    var mail = "kagome@sample.com";
    var id = mail.substring(0, mail.lastIndexOf("@"));
    System.out.println(id);

    for (int i = 0; i < mail.length(); i++) {
      System.out.print(i + ": " + mail.charAt(i) + ", ");
    }
    System.out.println();

    var str3 = "apple&banana&orange";
    var result = str3.split("[,&]", 2); // 正規表現, limit
    var result2 = String.join("\n", result);
    System.out.println(result2);
    // apple
    // banana&orange

    /*
        書式指定子
        %[index$][flag][width][.precision]conversion
    */

    // index
    System.out.println(String.format("%2$s", "Kagome", "Uri")); // Uri
    System.out.println(String.format("%3$d", "Kagome", "Uri", 11, 2)); // 11

    // width
    System.out.println(String.format("%10s", "Kagome", "Uri")); //     Kagome
    System.out.println(String.format("%2$10s", "Kagome", "Uri")); //        Uri
    System.out.println(String.format("%10s", "KagomeKagomeKagome")); // KagomeKagomeKagome

    // precision
    System.out.println(String.format("%.2s", "KagomeKagomeKagome")); // Ka

    // 整数
    System.out.println(String.format("%08d", 123)); // 00000123
    System.out.println(String.format("% 8d", 123)); //      123

    // 浮動小数点数
    System.out.println(String.format("%.2f", 1.2345)); // 1.23
    System.out.println(String.format("%.10f", 1.2345)); // 1.2345000000
    System.out.println(String.format("%.2e", 1234.5)); // 1.23e+03

    // 日付
    var now = LocalDateTime.now();
    System.out.println(String.format("%tF", now)); // %tでも%Tでもどちらでも可
    System.out.println(String.format("%tF", now)); // 2025-05-02
    System.out.println(String.format("%tD", now)); // 05/02/25
    System.out.println(String.format("%tT", now)); // 18:11:04
    System.out.println(String.format("%tr", now)); // 06:12:22 午後
    System.out.println(String.format("%tY", now)); // 2025
    System.out.println(String.format("%ty", now)); // 25
    // System.out.println(String.format("%tY %tm %td", now)); // このようにはできない。エラーになる
    System.out.println(String.format("%tY %tm %td", now, now, now)); // 2025 05 02
    System.out.println(String.format("%1$tY %1$tm %1$td", now)); // 2025 05 02

    // printfメソッド
    System.out.printf("%2$s\n", "Kagome", "Uri"); // Uri（改行）
    // printメソッドと一緒で改行が入らないので注意

    // formattedメソッド
    var str4 = "I am %1$s";
    System.out.println(str4.formatted("kagome", "uri", "uriko")); // I am kagome

    // 練習問題
    var str5 = "プログラミング言語";
    String result3 = str5.substring(4, 7);
    System.out.println(result3);

    var str6 = "鈴木\t太郎\t男\t50歳\t広島県";
    var result4 = str6.split("\t");
    var result5 = String.join("&", result4);
    System.out.println(result5);
  }
}
