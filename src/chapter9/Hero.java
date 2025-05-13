package chapter9;

// 1.2.1 #toString()のオーバーライド
public class Hero {
  private String name;
  private int hp;

  public Hero(String name, int hp) {
    this.name = name;
    this.hp = hp;
  }

  @Override
  public String toString() {
    return "Hero: Name->" + this.name + ", HP->" + this.hp;
  }

  public static void main(String[] args) {
    Hero kagome = new Hero("kagome", 100);

    System.out.println(kagome);
    // println()の引数は、.toString()が自動で呼び出される
    // toString()をオーバーライドしない場合: chapter9.Hero@4783da3f
    // toString()をオーバーライドした場合: Hero: Name->kagome, HP->100
  }
}
