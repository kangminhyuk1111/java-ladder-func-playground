package ui;

import domain.Ladder;
import domain.Line;

public class OutputView {

  public static final String VERTICAL_LINE = "|";
  public static final String CONNECTED_LINE = "-----";
  public static final String BLANK_SPACE = "     ";

  private OutputView() {

  }

  public static void printLadder(final Ladder ladder) {
    final StringBuilder ladderBuilder = new StringBuilder();

    for (Line line : ladder.getLines()) {
      final String lineString = printSingleLine(line);
      ladderBuilder.append(lineString);
    }

    System.out.print(ladderBuilder);
  }

  private static String printSingleLine(final Line line) {
    final StringBuilder lineBuilder = new StringBuilder();

    lineBuilder.append(VERTICAL_LINE);

    for (int i = 0; i < line.size(); i++) {
      lineBuilder.append(line.isConnected(i) ? CONNECTED_LINE : BLANK_SPACE);
      lineBuilder.append(VERTICAL_LINE);
    }

    lineBuilder.append("\n");

    return lineBuilder.toString();
  }
}
