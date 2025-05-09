package chapter6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSample {
  public static void main(String[] args) {
    var map =
        new HashMap<String, String>(
            Map.of("Rose", "バラ", "Sunflower", "ひまわり", "Morning Glory", "あさがお"));

    System.out.println(map.containsKey("Rose")); // true
    System.out.println(map.containsValue("あさがお")); // true

    for (var key : map.keySet()) {
      System.out.println(key);
    }
    // Sunflower
    // Morning Glory
    // Rose

    for (var val : map.values()) {
      System.out.println(val);
    }
    // ひまわり
    // あさがお
    // バラ

    for (var entry : map.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    // Sunflower:ひまわり
    // Rose:バラ
    // Morning Glory:あさがお

    var key1 = Integer.valueOf(128);
    var key2 = Integer.valueOf(128);
    // var map2 = new HashMap<Integer, String>(Map.of(key1, "hoge", key2, "fuga")); //
    // キーの重複は不可。エラー発生
    var map3 =
        new HashMap<Integer, String>() {
          {
            put(key1, "hoge");
            put(key2, "fuga");
          }
        }; //  キーの重複は不可だが、これなら置き換えの処理が行われるだけなので、エラーは発生しない
    System.out.println(map3); // {128=fuga}

    var map4 =
        new IdentityHashMap<Integer, String>() {
          {
            put(key1, "hoge");
            put(key2, "fuga");
          }
        };
    System.out.println(map4); // {128=fuga, 128=hoge}

    // ツリーマップは要素が追加される度、辞書順に並び替えられる
    var map5 =
        new TreeMap<String, String>(
            Map.of("Rose", "バラ", "Sunflower", "ひまわり", "Morning Glory", "あさがお"));
    for (var key : map5.keySet()) {
      System.out.println(key);
    }
    // Morning Glory
    // Rose
    // Sunflower

    // ラムダ式で、キーの文字列の短い順に
    var map6 = new TreeMap<String, String>((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    map6.putAll(Map.of("Morning Glory", "ひまわり", "Rose", "バラ", "Sunflower", "あさがお"));
    System.out.println(map6); // {Rose=バラ, Sunflower=ひまわり, Morning Glory=あさがお}

    // ラムダ式ではなく、Comparatorクラスのメソッドで順序を決定
    var map7 =
        new TreeMap<String, String>(Comparator.comparing(String::length)) {
          {
            putAll(Map.of("Rose", "バラ", "Sunflower", "ひまわり", "Morning Glory", "あさがお"));
          }
        };
  }
}
