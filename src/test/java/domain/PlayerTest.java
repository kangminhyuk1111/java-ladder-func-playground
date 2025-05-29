package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PlayerTest {

  @Test
  void 플레이어_이름이_정상적으로_생성된다() {
    String name = "홍길동";

    Player player = new Player(name);

    assertThat(player.name()).isEqualTo("홍길동");
  }

  @Test
  void 플레이어_이름이_5글자_이상이면_예외가_발생한다() {
    String longName = "매우긴이름입니다";

    assertThatThrownBy(() -> new Player(longName))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void 플레이어_이름이_4글자면_정상_생성된다() {
    String name = "김철수박";

    Player player = new Player(name);

    assertThat(player.name()).isEqualTo("김철수박");
  }

  @Test
  void 같은_이름의_플레이어는_동일하다() {
    Player player1 = new Player("홍길동");
    Player player2 = new Player("홍길동");

    assertThat(player1).isEqualTo(player2);
  }
}