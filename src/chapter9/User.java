package chapter9;

// 1.7 レコード
public record User(String name, int id) {
  public User() {
    this("No Name", 0);
  }

  // コンパクト・コンストラクタ
  public User {
    if (id < 0) throw new IllegalArgumentException(); // this.idとしてはならない
  }

  public static void main(String[] args) {
    User kagome = new User("kagome", 1000);
    System.out.println("Name: " + kagome.name() + " ID: " + kagome.id()); // Name: kagome ID: 1000
  }
}

// recordで自動で宣言されるもの
// - private修飾された各フィールド
// - 全フィールドを引数に取るコンストラクタ
// - 各フィールドと同名のゲッター（○->name(), ×->getName()）
// - 全フィールドの内容を用いた#toString()
// - 全フィールドの同値比較を用いた#equals()
// - 全フィールドの内容を用いた#hashCode()

// 注意点
// - ブロック内でフィールドを宣言できない（すべてレコードヘッダに記述）
// - セッターは生成されない（不変クラスであることが強制される）
// - コンパクト・コンストラクタでコンストラクタの入力値の検証ができる
// - 継承することもされることもできない（インターフェースを実装することは可能）
//   - レコードのような、単なるデータの集まりではないクラスでequals()やtoString()を省略したい場合は、
//     レコード構文ではなく、commons-langライブラリやLombokを利用する
