package chapter9second;

// シールクラス
public sealed class Character permits Hero, Wizard {
  public void heal(Character target) {
    switch (target) {
      case Hero h -> h.hp += 20;
      case Wizard w -> w.hp += 5;
      default -> {}
    }
  }
}
