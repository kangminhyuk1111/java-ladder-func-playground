package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

  private final Ladder ladder;

  public LadderGame(final Ladder ladder, final Rewards rewards) {
    validateLadderGame(ladder, rewards);
    this.ladder = ladder;
  }

  public LadderResult run(Players players, Rewards rewards) {
    Map<Integer, Integer> results = new HashMap<>();

    int width = ladder.width();

    for (int startPosition = 0; startPosition < width; startPosition++) {
      int finalPosition = runSinglePath(startPosition);
      results.put(startPosition, finalPosition);
    }

    return new LadderResult(results, players, rewards);
  }

  public Ladder getLadder() {
    return ladder;
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

  private void validateLadderGame(final Ladder ladder, final Rewards rewards) {
    if (ladder.width() != rewards.size()) {
      throw new RuntimeException("사용자 수와 리워드 수는 동일해야 합니다.");
    }
  }
}
