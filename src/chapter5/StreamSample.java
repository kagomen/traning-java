package chapter5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;

public class StreamSample {
  public static void main(String[] args) throws IOException {
    // ファイルの書き込み
    var writer =
        Files.newBufferedWriter(Paths.get("./src/data/data.log"), StandardOpenOption.APPEND);
    writer.write(LocalDateTime.now().toString());
    writer.newLine();
    writer.close();

    // 既にデータセットがある場合はFiles.write()を使うとシンプルに書ける
    Files.write(
        Paths.get("./src/data/hiragana.log"),
        List.of("あいうえお", "かきくけこ", "さしすせそ"),
        StandardCharsets.UTF_8);

    // ファイルの読み込み
    var reader = Files.newBufferedReader(Paths.get("./src/data/data.log"));
    var line = "";
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
    reader.close();

    // リストとして取得（ファイルサイズが大きい場合メモリ消費量が大きくなるので、ファイルサイズが小さいものに限る）
    var lines = Files.readAllLines(Paths.get("./src/data/data.log"));
    System.out.println(lines);
    // -> [
    // 2025-05-07T14:58:16.884520, 2025-05-07T14:58:16.884581,
    // 2025-05-07T14:58:16.884591, 2025-05-07T15:37:43.199712,
    // 2025-05-07T15:38:02.356251, 2025-05-07T15:40:42.369805
    // ]

    // バイナリファイルの読み・書き
    var fis = new FileInputStream("./src/data/input.png");
    var in = new BufferedInputStream(fis);
    var fos = new FileOutputStream("./src/data/output.png");
    var out = new BufferedOutputStream(fos);
    var data = -1;
    while ((data = in.read()) != -1) {
      out.write((byte) data);
    }
    in.close();
    out.close();
  }
}
