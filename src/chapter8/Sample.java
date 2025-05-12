package chapter8;

public class Sample {
  // アクセス修飾子とは、クラスやフィールド、メソッドに対するアクセス制限を指定する修飾子。
  // public: どのクラスからもアクセス可能
  // protected: クラス内、同じパッケージ内のクラス、サブクラス
  // なし: クラス内、同じパッケージ内のクラス
  // private: クラス内

  // アクセサメソッドを介してフィールドにアクセスするメリットは、フィールドを変更しても、そのフィールドを使用している他クラスに影響がなく、
  // アクセサメソッドのみ修正すればよいので、保守が楽。
  // フィールドを設定・参照する際に、検証が可能

  // final
  // 継承は依存性が強く、スーパークラスで変更があるとサブクラスも変更をする可能性があり、保守が大変。また、何をオーバーライドしていて何をオーバーライドしていないかがわかりにくいため、
  // サブクラスを使用する際は確認が多い。

  // true, true, sankaku, false

  public static void main(String[] args) {
    new Child("kagome");

    var ps = new Practice4Sub();
    ps.value = 20.9864;
    System.out.println(ps.show());

    var hm = new Hamster("uri");
    hm.move();
  }

  // public class Person(){
  //   public show(){
  //     System.out.println("Person");
  //   }
  // }

  // public class BusinessPerson extends Person(){
  //   public show(){
  //     System.out.println("BusinessPerson"); // オーバーライド
  //   }
  //   public work(){ ... } // メソッドの追加
  // }

  // Person p = new BusinessPerson();
  // p.show(); // -> BusinessPerson 実体はBusinessPerson型だから
  // p.work(); //エラー。理由はPerson型だから

}
