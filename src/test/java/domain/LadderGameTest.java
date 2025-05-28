package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class LadderGameTest {

  @Test
  void 연결이_없는_사다리_테스트() {
    BooleanGenerator alwaysFalse = () -> false;
    Ladder ladder = Ladder.testOf(4, 3, alwaysFalse);
    LadderGame game = new LadderGame(ladder);

    LadderResult result = game.run();

    assertThat(result.results()).hasSize(4);
    assertThat(result.getResult(0)).isEqualTo(0);
    assertThat(result.getResult(1)).isEqualTo(1);
    assertThat(result.getResult(2)).isEqualTo(2);
    assertThat(result.getResult(3)).isEqualTo(3);
  }

  @Test
  void 모든_연결이_있는_사다리_테스트() {
    BooleanGenerator alwaysTrue = () -> true;
    Ladder ladder = Ladder.testOf(4, 1, alwaysTrue);
    LadderGame game = new LadderGame(ladder);

    LadderResult result = game.run();

    assertThat(result.results()).hasSize(4);
    assertThat(result.getResult(0)).isEqualTo(1);
    assertThat(result.getResult(1)).isEqualTo(0);
    assertThat(result.getResult(2)).isEqualTo(3);
    assertThat(result.getResult(3)).isEqualTo(2);
  }
}