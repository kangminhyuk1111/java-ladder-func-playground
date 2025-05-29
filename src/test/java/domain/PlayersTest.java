package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @Test
  void 플레이어_목록이_정상적으로_생성된다() {
    List<Player> playerList = List.of(
        new Player("홍길동"),
        new Player("김철수")
    );

    Players players = new Players(playerList);

    assertThat(players.size()).isEqualTo(2);
  }

  @Test
  void 플레이어_목록이_null이면_예외가_발생한다() {
    assertThatThrownBy(() -> new Players(null))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void 플레이어_이름으로_인덱스를_찾는다() {
    List<Player> playerList = List.of(
        new Player("홍길동"),
        new Player("김철수")
    );
    Players players = new Players(playerList);
    Player target = new Player("김철수");

    int index = players.findPlayerIndexByName(target);

    assertThat(index).isEqualTo(1);
  }
}