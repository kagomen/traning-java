package chapter9second;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private String firstName;
  private String lastName;
  private String[] mamos;

  private static class Sub {}

  public static <T> ArrayList<T> newArrayList(T... values) {
    // var list = new ArrayList<T>();
    // for(var val :values){
    //   list.add(val);
    // }
    return new ArrayList<T>(List.of(values));
  }

  @Override
  public String toString() {
    return "Person: " + this.firstName + this.lastName;
  }

  public static void main(String[] args) {}
}
