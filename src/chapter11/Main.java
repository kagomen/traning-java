package chapter11;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    System.out.println("Start!");
    var th = new Print();
    th.start();
    String input = new Scanner(System.in).nextLine();
    System.out.println(input);
  }
}

class Print extends Thread {
  @Override
  public void run() {
    for (int i = 9; i >= 0; i--) {
      System.out.println(i);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

/*
スレッド利用の注意点
- 例外は他のスレッドに伝播しない
- JVMがOSごとの差を吸収してくれてはいるが、スレッドは別。このため、OSによって違う動作をする恐れがある
  - 仮想スレッドはOSの差を結構吸収してくれる
- 複数のスレッドが同時に1つの変数を利用するとデータが壊れる
  - synchronizedやAtomic系クラス、Concurrent系コレクションを利用して、スレッドセーフな設計をする
 */
