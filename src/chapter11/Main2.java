package chapter11;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main2 {
  public static void main(String[] args) {
    System.out.println("Start!");
    var t = new Print2();
    t.start();

    String input = new Scanner(System.in).nextLine();
    if (input.equals("stop")) {
      t.stopRequest.set(true);
    }
    try {
      t.join();
    } catch (Exception e) {
    }
  }
}

class Print2 extends Thread {
  final AtomicBoolean stopRequest = new AtomicBoolean(false);

  @Override
  public void run() {
    for (int i = 9; i >= 0; i--) {
      if (this.stopRequest.get()) {
        break;
      }
      System.out.println(i);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}