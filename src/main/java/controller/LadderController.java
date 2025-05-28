package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResult;
import ui.InputView;
import ui.OutputView;

public class LadderController {

  public void run() {
    final int width = InputView.inputLadderWidth();
    final int height = InputView.outputLadderHeight();

    final Ladder ladder = Ladder.of(width, height);

    OutputView.printLadder(ladder);

    final LadderGame game = new LadderGame(ladder);
    final LadderResult result = game.run();

    OutputView.printLadderResult(result);
  }
}
