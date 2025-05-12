package chapter8;

public class Hamster implements Mammal {
  private String name;

  public Hamster(String name) {
    this.name = name;
  }

  @Override
  public void move() {
    System.out.printf("%sはとことこ歩く", this.name);
  }
}
