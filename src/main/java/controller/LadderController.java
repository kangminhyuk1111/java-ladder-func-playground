package controller;

import domain.Ladder;
import ui.InputView;
import ui.OutputView;

public class LadderController {

  public void run() {
    final int width = InputView.inputLadderWidth();
    final int height = InputView.outputLadderHeight();

    final Ladder ladder = createLadder(width, height);

    OutputView.printLadder(ladder);
  }

  private Ladder createLadder(final int width, final int height) {
    return new Ladder(width, height);
  }
}
