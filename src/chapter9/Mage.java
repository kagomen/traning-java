package chapter9;

// 1.6 #clone()のオーバーライド
public class Mage implements Cloneable {
  String name;
  int hp;
  Magic magic;

  public Mage(String name, int hp, Magic magic) {
    this.name = name;
    this.hp = hp;
    this.magic = magic;
  }

  @Override
  public Mage clone() {
    return new Mage(this.name, this.hp, this.magic.clone());
  }

  public static void main(String[] args) {
    Mage kagome = new Mage("kagome", 100, new Magic("火の玉"));
    Mage kagome2 = kagome;
    kagome.name = "changed";
    System.out.println(kagome2.name); // changed
    // 上記ではアドレスがコピーされるだけ

    Mage uri = new Mage("uri", 100, new Magic("発光"));
    Mage uri2 = new Mage(uri.name, uri.hp, uri.magic);
    uri.name = "changed";
    System.out.println(uri2.name); // uri
    // 値をコピーしたい場合は、新しくインスタンスを作成する必要がある

    // 上記の代わりに、#clone()で複製されたインスタンスを得ることが可能（clone()はオーバーライド必須）
    Mage tabi = new Mage("tabi", 100, new Magic("飛ぶ"));
    Mage tabi2 = tabi.clone();
    tabi.name = "changed";
    tabi.magic.setName("飛ばない");
    System.out.println(tabi2.name); // tabi
    System.out.println(tabi2.magic.getName()); // 飛ぶ
    // MagicクラスもCloneableを実装しないとシャローコピーされてしまい、「飛ばない」が出力される
  }
}
