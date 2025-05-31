package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private final List<Boolean> connects;

  public Line(final int width, final BooleanGenerator booleanGenerator) {
    this.connects = new ArrayList<>();

    for (int i = 0; i < width - 1; i++) {
      final boolean canConnect = !isPreviousConnected();
      final boolean connectStatus = canConnect && booleanGenerator.nextBoolean();
      connects.add(connectStatus);
    }
  }

  public Line(final List<Boolean> connects) {
    validateConnects(connects);
    this.connects = connects;
  }

  private boolean isPreviousConnected() {
    if (connects.isEmpty()) {
      return false;
    }

    return connects.get(connects.size() - 1);
  }

  public boolean isConnected(final int index) {
    return connects.get(index);
  }

  public int size() {
    return connects.size();
  }

  private void validateConnects(List<Boolean> connections) {
    for (int i = 0; i < connections.size() - 1; i++) {
      if (connections.get(i) && connections.get(i + 1)) {
        throw new RuntimeException("연속된 연결은 허용되지 않습니다.");
      }
    }
  }
}
