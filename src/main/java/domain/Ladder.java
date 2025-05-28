package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private final List<Line> lines;

  private Ladder(final int width, final int height, final BooleanGenerator booleanGenerator) {
    validateWidth(width);
    validateHeight(height);

    this.lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(new Line(width, booleanGenerator));
    }
  }

  public static Ladder of(final int width, final int height) {
    return new Ladder(width, height, new RandomBooleanGenerator());
  }

  static Ladder testOf(final int width, final int height, final BooleanGenerator generator) {
    return new Ladder(width, height, generator);
  }

  public List<Line> lines() {
    return lines;
  }

  public int width() {
    return lines().get(0).size() + 1;
  }

  public int height() {
    return lines.size();
  }

  private void validateWidth(int width) {
    if (width < 2) {
      throw new RuntimeException("사다리 폭은 최소 2 이상이어야 합니다.");
    }
  }

  private void validateHeight(int height) {
    if (height < 1) {
      throw new RuntimeException("사다리 높이는 최소 1 이상이어야 합니다.");
    }
  }
}
