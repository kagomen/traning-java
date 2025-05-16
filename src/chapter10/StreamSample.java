package chapter10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class StreamSample {
  public static void main(String[] args) {
    var list = List.of("john", "bob", "tom");
    list.stream().map(item -> "hello " + item).forEach(System.out::println);
    // hello john
    // hello bob
    // hello tom

    var list2 = List.of(List.of("taro", "jiro"), List.of("saburo", "shiro"));

    list2.stream().forEach(System.out::println);
    // [taro, jiro]
    // [saburo, shiro]

    // flatMap()でリストの要素をStreamオブジェクト化
    list2.stream().flatMap(v -> v.stream()).forEach(System.out::println);
    // taro
    // jiro
    // saburo
    // shiro

    // ❌リストに対しStreamオブジェクト化してしまっている
    list2.stream().map(v -> v.stream()).forEach(System.out::println);
    // java.util.stream.ReferencePipeline$Head@4d405ef7
    // java.util.stream.ReferencePipeline$Head@6193b845

    // mapMulti()はflatMap()に比べてStreamオブジェクト生成が無い分、効率的
    list2.stream()
        .<String>mapMulti(
            (val, consumer) -> {
              for (var v : val) {
                consumer.accept("hello " + v); // String型の値を受け取り、処理を実行
              }
            })
        .forEach(System.out::println);
    // taro
    // jiro
    // saburo
    // shiro

    var set = new HashSet<String>();
    Stream.of(
            new Person("john", 20),
            new Person("Bob", 30),
            new Person("Tom", 25),
            new Person("Tom", 30))
        .filter(p -> set.add(p.name))
        .forEach(System.out::println);
    // john:20
    // Bob:30
    // Tom:25

    System.out.println(
        Stream.of("john", "bob", "tom").reduce((result, v) -> result + "," + v).orElse("nobody"));
    // john,bob,tom

    System.out.println(
        Stream.of("john", "bob", "tom")
            .collect(ArrayList<String>::new, (li, v) -> li.add(v), (l1, l2) -> l1.addAll(l2)));
    // [john, bob, tom]

  }
}

class Person {
  String name;
  int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return this.name + ":" + this.age;
  }
}
