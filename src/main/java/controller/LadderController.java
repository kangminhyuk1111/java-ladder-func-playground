package controller;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import ui.InputView;
import ui.OutputView;
import util.InputParser;

public class LadderController {

  public void run() {
    final Players players = inputPlayers();
    final Rewards rewards = inputRewards();
    final int height = InputView.inputLadderHeight();
    final BooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

    final LadderGame game = createLadderGame(players, rewards, height, randomBooleanGenerator);
    final LadderResult results = game.run(players, rewards);

    printResults(players, rewards, game, results);
  }

  private Players inputPlayers() {
    final String playersString = InputView.inputPlayers();
    return InputParser.parsePlayers(playersString);
  }

  private Rewards inputRewards() {
    final String rewardString = InputView.inputReward();
    return InputParser.parseRewards(rewardString);
  }

  private LadderGame createLadderGame(final Players players, final Rewards rewards, final int height, final BooleanGenerator booleanGenerator) {
    final int width = players.size();
    final List<Line> lines = createLines(width, height, booleanGenerator);

    final Ladder ladder = Ladder.of(lines);

    return new LadderGame(ladder, rewards);
  }

  private List<Line> createLines(final int width, final int height, final BooleanGenerator booleanGenerator) {
    List<Line> lines = new ArrayList<>();

    for (int i = 0; i < height; i++) {
      lines.add(new Line(width, booleanGenerator));
    }

    return lines;
  }

  private void printResults(final Players players, final Rewards rewards, final LadderGame game, final LadderResult results) {
    OutputView.printGameResult(players, game.getLadder(), rewards);
    OutputView.printResults(results);
  }
}
