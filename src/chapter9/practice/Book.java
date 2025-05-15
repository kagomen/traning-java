package chapter9.practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Book implements Cloneable, Comparable<Book> {
  private String title;
  private LocalDate publishDate;
  private String comment;

  public Book(String title, LocalDate publishDate, String comment) {
    this.title = title;
    this.publishDate = publishDate;
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "[Title: " + this.title + ", Published at: " + this.publishDate + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (!(obj instanceof Book)) return false;
    Book r = (Book) obj;
    if (this.title.equals(r.title) && this.publishDate.equals(r.publishDate)) return true;
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.title, this.publishDate);
  }

  @Override
  public int compareTo(Book obj) {
    return this.publishDate.compareTo(obj.publishDate);
  }

  @Override
  public Book clone() {
    return new Book(this.title, (LocalDate) this.publishDate, this.comment);
  }

  public String getTitle() {
    return title;
  }

  public static void main(String[] args) {
    Book book1 = new Book("Java入門", LocalDate.of(2011, 10, 7), "スッキリわかる");
    Book book2 = new Book("Python入門", LocalDate.of(2019, 6, 11), "カレーが食べたくなる");
    Book book3 = new Book("C言語入門", LocalDate.of(2018, 6, 21), "ポインタも自由自在");

    List<Book> list = new ArrayList<>();
    list.add(book1);
    list.add(book2);
    list.add(book3);

    System.out.println(list);

    Collections.sort(list); // 自然順序（出版日順）
    System.out.println(list);

    Collections.sort(list, new TitleComparator()); // タイトル順
    // 匿名クラスを利用して以下のようにも記述できる
    // Collections.sort(
    //     list,
    //     new Comparator<Book>() {
    //       public int compare(Book x, Book y) {
    //         return (x.getTitle().compareTo(y.getTitle()));
    //       }
    //     });

    System.out.println(list);
  }
}
