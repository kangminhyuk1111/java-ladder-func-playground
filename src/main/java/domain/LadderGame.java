package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

  private final Ladder ladder;

  public LadderGame(final Ladder ladder) {
    this.ladder = ladder;
  }

  public LadderResult run() {
    Map<Integer, Integer> results = new HashMap<>();

    int width = ladder.width();

    for (int startPosition = 0; startPosition < width; startPosition++) {
      int finalPosition = runSinglePath(startPosition);
      results.put(startPosition, finalPosition);
    }

    return new LadderResult(results);
  }

  private int runSinglePath(final int startPosition) {
    int currentPosition = startPosition;

    for (Line line : ladder.lines()) {
      currentPosition = movePosition(currentPosition, line);
    }

    return currentPosition;
  }

  private boolean canMoveRight(final int position, final Line line) {
    return position >= 0 && position < line.size() && line.isConnected(position);
  }

  private boolean canMoveLeft(final int position, final Line line) {
    return position > 0 && position <= line.size() && line.isConnected(position - 1);
  }

  private int movePosition(final int currentPosition, final Line line) {
    if (canMoveRight(currentPosition, line)) {
      return currentPosition + 1;
    }

    if (canMoveLeft(currentPosition, line)) {
      return currentPosition - 1;
    }

    return currentPosition;
  }
}