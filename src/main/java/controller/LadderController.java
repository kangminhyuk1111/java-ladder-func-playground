package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResult;
import domain.Player;
import domain.Players;
import domain.Rewards;
import java.util.List;
import ui.InputView;
import ui.OutputView;
import util.InputParser;

public class LadderController {

  public void run() {
    // 사용자, 결과 입력받기
    final String playersString = InputView.inputPlayers();
    final String rewardString = InputView.inputReward();

    // 도메인으로 변환
    final Players players = InputParser.parsePlayers(playersString);
    final Rewards rewards = InputParser.parseRewards(rewardString);

    // 사다리 가로 세로 넓이 찾기
    final int width = players.players().size();
    final int height = InputView.inputLadderHeight();

    // 사다리 참조 게임 생성
    final Ladder ladder = Ladder.of(width, height);
    final LadderGame game = new LadderGame(ladder);

    // 게임 결과 반환
    final LadderResult results = game.run();

    // 사다리 결과 ui 반환
    OutputView.printGameResult(players, ladder, rewards);

    // 사다리 결과 단건 혹은 all 검색시 조건 맞춰 반환
    OutputView.printResults(players, rewards, results);
  }
}
