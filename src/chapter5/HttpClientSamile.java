package chapter5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientSamile {
  public static void main(String[] args) throws IOException, InterruptedException {

    // リクエスト送信の中心的役割を果たすHttpClientインスタンスを生成
    var client = HttpClient.newBuilder().build();

    // 送信するリクエストの内容を指定するHttpRequestインスタンスを生成
    var req = HttpRequest.newBuilder().uri(URI.create("https://codezine.jp/")).build();

    // リクエストを送信
    var res =
        client.send(
            req, HttpResponse.BodyHandlers.ofString() // レスポンスボディのデータ形式をStringに指定
            );
    System.out.println(res.body()); // レスポンスからボディを取得、コンソールに表示

    // 非同期にリクエストを送信
    // client
    //     .sendAsync(req, HttpResponse.BodyHandlers.ofString())
    //     .thenAccept(
    //         res -> {
    //           System.out.println(res.body());
    //         })
    //     .join();

    // POSTリクエスト
    var reqOfPost =
        HttpRequest.newBuilder()
            .uri(URI.create("https://wings.msn.to/tmp/post.php"))
            .header("Content-Type", "application/json")
            .POST(
                HttpRequest.BodyPublishers.ofString("{\"name\": \"kagome\"}")) // 文字列をリクエストボディとして生成
            .build();

    var resOfPost = client.send(reqOfPost, HttpResponse.BodyHandlers.ofString());
    System.out.println(resOfPost.body());
  }
}
