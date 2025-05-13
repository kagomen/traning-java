package chapter9.practice;

import java.util.ArrayList;
import java.util.List;

public record Monster(String name, int hp, boolean isBoss) {
  public Monster {
    if (hp < 0) throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    List<Monster> list = new ArrayList<>();

    list.add(new Monster("お化けキノコ", 10, false));
    list.add(new Monster("ゴブリン", 25, false));
    list.add(new Monster("ドラゴン", 120, true));

    for (Monster m : list) {
      System.out.println(m.name() + " HP:" + m.hp() + " Boss?:" + m.isBoss());
    }
  }
}
