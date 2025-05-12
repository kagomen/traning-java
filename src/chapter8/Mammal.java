package chapter8;

public interface Mammal {
  default void move() {
    System.out.println("walk");
  }
}
