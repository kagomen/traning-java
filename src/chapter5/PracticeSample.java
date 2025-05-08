package chapter5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.regex.Pattern;

public class PracticeSample {
  public static void main(String[] args) {

    var txt1 = "となりのきゃくはよくかきくうきゃくだ";
    System.out.println(txt1.lastIndexOf("きゃく"));

    var txt2 = "%sの気温は%.2f度です";
    var result2 = String.format(txt2, "千葉", 17.256);
    System.out.println(result2);

    var txt3 = "彼女の名前は花子です。";
    var result3 = txt3.replace("彼女", "妻");
    System.out.println(result3);

    var now = LocalDateTime.now();
    System.out.println(now.plus(Duration.parse("P5DT6H")));

    var time1 = LocalDate.of(2024, 3, 12);
    var time2 = LocalDate.of(2024, 11, 5);
    var period = Period.between(time1, time2);
    System.out.println(period.getMonths() + "ヶ月" + period.getDays() + "日間");

    var ptn = Pattern.compile(".+");
    try (var reader = Files.newBufferedReader(Paths.get("./src/data/data.log"))) {
      var line = "";
      while ((line = reader.readLine()) != null) {
        var match = ptn.matcher(line);
        while (match.find()) {
          System.out.println(match.group());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (var writer =
        Files.newBufferedWriter(Paths.get("./src/data/hiragana.log"), StandardOpenOption.APPEND)) {
      writer.write(String.join(",", args));
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(Math.pow(6, 3));
    System.out.println(Math.abs(-15));
    var arr = new int[] {110, 14, 28, 32};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
