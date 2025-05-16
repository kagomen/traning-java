package chapter10;

import java.util.function.IntToDoubleFunction;

public class Main2 {
  public static void main(String[] args) {

    IntToDoubleFunction func =
        (int x) -> {
          return x * x * 3.14;
        };

    IntToDoubleFunction func2 =
        (x) -> {
          return x * x * 3.14;
        };

    IntToDoubleFunction func3 =
        x -> {
          return x * x * 3.14;
        };

    IntToDoubleFunction func4 = (int x) -> x * x * 3.14;

    IntToDoubleFunction func5 = (x) -> x * x * 3.14;

    IntToDoubleFunction func6 = x -> x * x * 3.14;

    double PI = 3.14; // PIはラムダ式の中で書き換えることはできない。ラムダ式内で取得する変数は、内容が変化しない、実質finalな変数である必要がある
    IntToDoubleFunction func7 = x -> x * x * PI;
  }
}
