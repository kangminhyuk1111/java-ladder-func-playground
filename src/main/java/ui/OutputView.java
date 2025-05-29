package ui;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Rewards;
import java.util.List;

public class OutputView {

  public static final String VERTICAL_LINE = "|";
  public static final String CONNECTED_LINE = "-----";
  public static final String BLANK_SPACE = "     ";
  public static final String ALL = "all";

  private OutputView() {

  }

  public static void printGameResult(Players players, Ladder ladder, Rewards rewards) {
    System.out.println("사다리 결과 \n");
    
    printPlayersName(players);
    printLadder(ladder);
    printRewards(rewards);
  }

  public static void printResults(Players players, Rewards rewards, LadderResult results) {
    while (true) {
      final String target = InputView.inputResultTarget();

      if (target.equals(ALL)) {
        OutputView.printAllResults(players, rewards, results);
        break;
      }

      final Player player = new Player(target);
      final int playerIndex = players.findPlayerIndexByName(player);

      if (playerIndex == -1) {
        System.out.println("존재하지 않는 플레이어입니다.");
        continue;
      }

      final int resultIndex = results.getResult(playerIndex);
      final String reward = rewards.getReward(resultIndex);

      OutputView.printReward(reward);
    }
  }

  private static void printReward(final String reward) {
    System.out.println("실행 결과");
    System.out.println(reward);
  }

  private static void printAllResults(Players players, Rewards rewards, LadderResult results) {
    System.out.println("실행 결과");
    for (int i = 0; i < players.players().size(); i++) {
      Player player = players.players().get(i);
      int resultIndex = results.getResult(i);
      String reward = rewards.getReward(resultIndex);
      System.out.println(player.name() + " : " + reward);
    }
  }

  private static void printPlayersName(Players players) {
    for (Player player : players) {
      System.out.print(player.name() + "\t");
    }
    System.out.println();
  }

  private static void printLadder(final Ladder ladder) {
    final StringBuilder ladderBuilder = new StringBuilder();

    for (Line line : ladder.lines()) {
      final String lineString = printSingleLine(line);
      ladderBuilder.append(lineString);
    }

    System.out.print(ladderBuilder);
  }

  private static void printRewards(Rewards rewards) {
    final List<String> item = rewards.rewards();
    for (String reward : item) {
      System.out.print(reward + "\t");
    }
    System.out.println();
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
