package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class LadderGameTest {

  @Test
  void 연결이_없는_사다리_테스트() {
    List<Line> lines = List.of(
            new Line(List.of(false, false, false)),
            new Line(List.of(false, false, false)),
            new Line(List.of(false, false, false))
    );

    Ladder ladder = Ladder.of(lines);
    Players players = new Players(Stream.of("kang", "min", "hyuk").map(Player::new).toList());
    Rewards rewards = new Rewards(List.of("1000","2000","3000","4000"));
    LadderGame game = new LadderGame(ladder, rewards);

    LadderResult result = game.run(players, rewards);

    assertThat(result.results()).hasSize(4);
    assertThat(result.getResult(0)).isEqualTo(0);
    assertThat(result.getResult(1)).isEqualTo(1);
    assertThat(result.getResult(2)).isEqualTo(2);
    assertThat(result.getResult(3)).isEqualTo(3);
  }

  @Test
  void 모든_연결이_있는_사다리_테스트() {
    List<Line> lines = List.of(
            new Line(List.of(true, false, true))
    );

    Ladder ladder = Ladder.of(lines);
    Players players = new Players(Stream.of("kang", "min", "hyuk").map(Player::new).toList());
    Rewards rewards = new Rewards(List.of("1000","2000","3000","4000"));
    LadderGame game = new LadderGame(ladder, rewards);

    LadderResult result = game.run(players, rewards);

    assertThat(result.results()).hasSize(4);
  }
}