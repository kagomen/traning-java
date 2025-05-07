package chapter5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class DateTime {
  public static void main(String[] args) {
    System.out.println(LocalDate.now()); // ->2025-05-07
    System.out.println(LocalDateTime.now()); // ->2025-05-07T12:33:22.891157

    // 数値から日付・時刻オブジェクトを生成
    System.out.println(LocalDate.of(2025, 5, 7)); // ->2025-05-07
    System.out.println(LocalDateTime.of(2025, 5, 5, 12, 37)); // ->2025-05-05T12:37

    // 文字列から日付オブジェクトを生成
    System.out.println(LocalDate.parse("2025-05-07"));

    // 文字列のフォーマットを指定し、日付オブジェクトを生成
    System.out.println(
        LocalDate.parse("2025-05-07T12:43:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    // 日付オブジェクトから指定要素を取得
    System.out.println(LocalDate.now().getMonth()); // ->MAY
    System.out.println(LocalDate.now().getMonthValue()); // ->5

    // フォーマット
    System.out.println(
        LocalDate.now()
            .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))); // ->2025年5月7日水曜日
    System.out.println(
        LocalDate.now()
            .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))); // ->2025/05/07
    System.out.println(
        LocalDate.now().format(DateTimeFormatter.ofPattern("Y年M月d日(E)"))); // ->2025年5月7日(水)

    // 差分
    var date1 = LocalDateTime.of(2020, 12, 24, 15, 8, 0);
    var date2 = LocalDateTime.now();
    var period = Period.between(date1.toLocalDate(), date2.toLocalDate());
    System.out.println(
        "差: "
            + period.getYears()
            + "年"
            + period.getMonths()
            + "ヶ月"
            + period.getDays()
            + "日間"); // ->差: 4年4ヶ月13日間
    var duration = Duration.between(date1, date2);
    System.out.println("差: " + duration.toHours() + "時間"); // ->差: 38279時間

    // 加算・減算
    System.out.println(LocalDate.now().plus(3, ChronoUnit.YEARS)); // ->2028-05-07
    System.out.println(LocalDate.now().minus(21, ChronoUnit.DAYS)); // ->2025-04-16

    // 練習問題
    System.out.println("月: " + LocalDateTime.now().getMonthValue());
    System.out.println("分: " + LocalDateTime.now().getMinute());
    System.out.println(LocalDate.now().plus(20, ChronoUnit.DAYS));
  }
}
