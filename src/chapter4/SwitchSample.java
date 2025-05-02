package chapter4;

public class SwitchSample {
  public static void main(String[] args) {
    var drink = "ビール";

    // 書き方1（フォールスルー）
    switch (drink) {
      case "ワイン":
      case "ビール":
      case "日本酒":
        System.out.println("醸造酒");
        break;
      case "ウィスキー":
      case "ブランデー":
        System.out.println("蒸留酒");
        break;
      default:
        break;
    }

    // 書き方2
    switch (drink) {
      case "ワイン", "ビール", "日本酒":
        System.out.println("醸造酒");
        break;
      case "ウィスキー", "ブランデー":
        System.out.println("蒸留酒");
        break;
      default:
        System.out.println("不明");
        break;
    }

    // 書き方3（Switch"式"）
    String result =
        switch (drink) {
          case "ワイン", "ビール", "日本酒" -> "醸造酒";
          case "ウィスキー", "ブランデー" -> "蒸留酒";
          default -> "不明";
        };
    System.out.println(result);
    // 自動でbreak相当の処理が行われるため、記述不要
    // yieldで値を返却している
    // returnと違って、yieldは処理を中断しない

    // 書き方3（Switch式のパターンマッチング）
    Object obj = -123;
    switch (obj) {
      case Integer i when i > 15 -> System.out.println(Math.abs(i));
      case String str -> System.out.println(str.substring(2));
      case null, default -> System.out.println("invalid");
    }
  }
}
