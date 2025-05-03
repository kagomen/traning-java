package chapter5;

import java.util.regex.Pattern;

public class RegexSample {
  public static void main(String[] args) {

    var tel = new String[] {"080-0000-0000", "084-000-0000", "184-0000"};
    var rx = "\\d{3}-\\d{3,4}(-\\d{4})?";

    for (var t : tel) {
      // System.out.println(Pattern.matches(rx, t));
      System.out.println(t.matches(rx));
    }

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
  }
}
