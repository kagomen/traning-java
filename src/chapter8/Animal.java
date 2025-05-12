package chapter8;

public class Animal {
  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Animal() {
    this("No Name", 0);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    if (age < 0) {
      this.age = 0;
      return;
    }
    this.age = age;
  }

  public String intro() {
    return String.format("I am %s, %d years old.", getName(), getAge());
  }
}
