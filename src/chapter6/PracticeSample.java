package chapter6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeSample {

  public static void main(String[] args) {
    var map =
        new HashMap<String, String>(
            Map.of("cucumber", "キュウリ", "lettuce", "レタス", "spinach", "ホウレンソウ"));
    map.put("carrot", "ニンジン");
    map.remove("spinach");
    map.put("cucumber", "胡瓜");

    for (var entry : map.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }

    var list = new ArrayList<Integer>(List.of(1, 2, 3, 4));
    list.add(100);
    list.set(2, 30);
    list.remove(3);
    for (var i : list) {
      System.out.println(i);
    }
  }
}
