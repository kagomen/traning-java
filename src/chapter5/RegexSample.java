package chapter5;

import java.util.regex.Pattern;

public class RegexSample {
  public static void main(String[] args) {

    var tel = new String[] {"080-0000-0000", "084-000-0000", "184-0000"};
    var rx = "\\d{3}-\\d{3,4}(-\\d{4})?";

    for (var t : tel) {
      // System.out.println(Pattern.matches(rx, t));
      System.out.println(t.matches(rx)); // -> true true true
    }

    //
    var rx2 = "(\\d{3})-(\\d{3,4})-?(\\d{4})?";
    var ptn = Pattern.compile(rx2);
    var telList = "";
    // Pattern matches;
    for (var t : tel) {
      telList += t;
    }
    var match = ptn.matcher(telList);
    while (match.find()) {
      System.out.println("=========");
      System.out.println("電話番号: " + match.group());
      System.out.println("市外局番: " + match.group(1));
    }

    // 名前付きキャプチャグループ
    var txt2 = "kagome: kagome";
    var ptn2 = Pattern.compile("(?<name>\\w+): \\k<name>");
    var match2 = ptn2.matcher(txt2);
    System.out.println("start");
    while (match2.find()) {
      System.out.println(match2.group("name"));
    }

    // 先読み・後読み
    var txt3 = "いろはにほへと";
    var ptn3 = Pattern.compile("いろ(?=はに)");
    var match3 = ptn3.matcher(txt3);
    while (match3.find()) {
      System.out.println(match3.group(0)); // -> いろ
    }
    var txt4 = "いろものですね。いろいろと";
    var match4 = ptn3.matcher(txt4);
    while (match4.find()) {
      System.out.println(match4.group()); // ->(なし)
    }

    // Unicodeプロパティエスケープ
    var txt5 = "このプロジェクトは1月に始まりました。";
    var ptn5 = Pattern.compile("\\p{IsKatakana}+");
    var match5 = ptn5.matcher(txt5);
    while (match5.find()) {
      System.out.println(match5.group()); // ->プロジェクト
    }
    var ptn6 = Pattern.compile("\\P{IsKatakana}+");
    var match6 = ptn6.matcher(txt5);
    while (match6.find()) {
      System.out.println(match6.group()); // ->この, は1月に始まりました。
    }

    // 置き換え
    var txt7 = "名前は桜です。桜と呼んでください。";
    System.out.println(txt7.replaceAll("桜(?=と)", "サクラ")); // ->名前は桜です。サクラと呼んでください。

    // 練習問題
    var txt8 = "住所は〒160-0000 新宿区南町0-0-0です。あなたの住所は〒210-9999 川崎市北町1-1-1ですね";
    var ptn8 = Pattern.compile("\\d{3}-\\d{4}");
    var match8 = ptn8.matcher(txt8);
    while (match8.find()) {
      System.out.println(match8.group());
    }

    var txt9 = "お問い合わせはsupport@example.comまで";
    var regex = "(?i)[a-z0-9.!#$%&'*+/=?^_{|}~-]+@[a-z0-9-]+(?:\\.[a-z0-9-]+)*";
    var result = txt9.replaceAll(regex, "<a href=\"mailto:$0\">$0</a>");
    System.out.println(
        result); // ->お問い合わせは<a href="mailto:support@example.com">support@example.com</a>まで
  }
}
