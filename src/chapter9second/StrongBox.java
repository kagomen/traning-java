package chapter9second;

import java.util.Optional;

public class StrongBox<E> {
  private E val;
  private KeyType keyType;
  private int count;

  public StrongBox(KeyType keyType) {
    this.keyType = keyType;
  }

  public void put(E val) {
    this.val = val;
  }

  public Optional<E> get() {
    this.count++;
    switch (this.keyType) {
      case PADLOCK -> {
        if (count < 1024) return null;
      }
      case BUTTON -> {
        if (count < 10000) return null;
      }
      case DIAL -> {
        if (count < 3000) return null;
      }
      case FINGER -> {
        if (count < 1000000) return null;
      }
    }
    this.count = 0;
    return Optional.ofNullable(this.val);
  }
}
