package chapter9;

public class Magic implements Cloneable {
  String name;

  public Magic(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Magic clone() {
    return new Magic(this.name);
  }
}
