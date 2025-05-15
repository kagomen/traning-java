package chapter9second;

import java.util.Optional;

// 独習Java 9章 例外処理
public class ExceptionSample {
  public Optional<String> find(String id) {
    return Optional.ofNullable(id);
  }

  public void sample(String val) {
    if (val == null) throw new NullPointerException();

    System.out.println(val);
  }

  public static void main(String[] args) {

    var user = new ExceptionSample();
    var id = user.find(null);

    System.out.println(id);

    int age = -1;

    assert age > 0 : "年齢は正数で入力してください";

    System.out.println(age);

    user.sample(null);

    // 詳細な例外クラスを先に記述すること。
    // アプリ側の例外は、Exceptionクラスが担当。Errorクラスは、回復処理ができないため、プログラムで扱わないでよい。
    // また、Exceptionクラスには、コンパイル時にエラーが発生する検査例外と、実行時にエラーが発生する非検査例外が存在する。
    // 検査例外は、クラス内でtry-catchで回復処理を行わない場合は、呼び出し元で必ず例外処理をする必要がある。
    // 呼び出し元に例外処理を任せる場合、あまりに細かいエラーは呼び出し元の例外処理コードが煩雑になるため、例外クラスをまとめてキャッチして、ひとつの例外クラスをthrowするとよい。
    // また、Exception派生クラスを継承して独自の例外クラスを作ることができるが、できるだけ標準例外を使用した方がよい。
  }
}
