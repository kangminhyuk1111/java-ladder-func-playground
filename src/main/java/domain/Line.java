package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private final List<Boolean> connects;

  public Line(final int width, final BooleanGenerator booleanGenerator) {
    this.connects = new ArrayList<>();

    for (int i = 0; i < width - 1; i++) {
      // 이전 boolean 체크하여 연결 가능한지 체크
      final boolean canConnect = !isPreviousConnected();
      // 이전 값 체크하여 가능 한지 && random을 통한 boolean 생성 후 둘다 true이면 다리 생성
      final boolean connectStatus = canConnect && booleanGenerator.nextBoolean();
      connects.add(connectStatus);
    }
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
}
