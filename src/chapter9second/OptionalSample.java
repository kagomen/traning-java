package chapter9second;

import java.util.Optional;

// 2.6 Null安全
public class OptionalSample {
  public static void main(String[] args) {
    Optional kagome = Optional.ofNullable("かごめ"); // ofNullable()かof()で値を格納する
    Optional nullKagome = Optional.ofNullable(null); // NullPointerExceptionは発生しない
    Optional uri = Optional.of("うり");
    // Optional nullUri = Optional.of(null); // NullPointerExceptionが発生する

    System.out.println(kagome.isPresent()); // true
    System.out.println(nullKagome.isPresent()); // false

    System.out.println(kagome.get()); // かごめ
    // System.out.println(nullKagome.get()); // NoSuchElementException

    System.out.println(kagome.orElse("変更")); // かごめ
    System.out.println(nullKagome.orElse("変更")); // 変更
  }
}

/*
Optionalクラスは参照型のみ対応
基本データ型でOptionalクラスを使いたい場合は、OptionalInt()やOptionalLong(), OptionalDouble()を使用すること
また、ラッパークラスでOptionalクラスを用いるのは処理効率が悪いので非推奨
 */
