package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private static final BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

  private final List<Line> lines;

  public Ladder(final int width, final int height) {
    validateWidth(width);
    validateHeight(height);

    this.lines = new ArrayList<>();

    for (int i = 0; i < height; i++) {
      lines.add(new Line(width, booleanGenerator));
    }
  }

  public List<Line> getLines() {
    return lines;
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
