package chapter5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.Normalizer;
import java.text.Normalizer.Form;

public class OthersSample {
  public static void main(String[] args) throws IOException {
    // Unicode正規化
    var list4 = new String[] {"ギガ", "ｷﾞｶﾞ", "㌐"};
    for (var val : list4) {
      System.out.println(Normalizer.normalize(val, Form.NFKC)); // ギガ ギガ ギガ
    }

    // Filesクラス
    var path = Paths.get("./src/data/data.log");
    System.out.println(Files.exists(path)); // true
    System.out.println(Files.isWritable(path)); // true
    System.out.println(Files.size(path));

    var path2 = Paths.get("./src/data/copy.txt");
    Files.copy(
        path, path2, StandardCopyOption.REPLACE_EXISTING); // オプションを設定しないと、既にファイルが存在する場合エラーになる
    Files.delete(path2);
  }
}
