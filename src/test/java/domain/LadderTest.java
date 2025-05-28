package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

  @Nested
  @DisplayName("사다리 생성 테스트 - 성공 케이스")
  class NormalLadderTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 10})
    void 사다리_생성_테스트(final int width) {
      int height = 5;

      Ladder ladder = new Ladder(width, height);

      assertThat(ladder.getLines()).hasSize(height);
      assertThat(ladder.getLines()).isNotNull();

      for (Line line : ladder.getLines()) {
        assertThat(line.size()).isEqualTo(width - 1);
      }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    void 다양한_높이_사다리_생성(final int height) {
      int width = 4;

      Ladder ladder = new Ladder(width, height);

      assertThat(ladder.getLines()).hasSize(height);
    }

    @Test
    void 최소_크기_사다리_생성() {
      Ladder ladder = new Ladder(2, 1);

      assertThat(ladder.getLines()).hasSize(1);
      assertThat(ladder.getLines().get(0).size()).isEqualTo(1);
    }
  }

  @Nested
  @DisplayName("사다리 생성 테스트 - 실패 케이스")
  class FailureLadderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, -5, -10})
    void 폭이_2_미만일_때_예외_발생(final int invalidWidth) {
      assertThatThrownBy(() -> new Ladder(invalidWidth, 5))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 폭이_0일_때_예외_발생() {
      assertThatThrownBy(() -> new Ladder(0, 3))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 폭이_음수일_때_예외_발생() {
      assertThatThrownBy(() -> new Ladder(-3, 5))
          .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -10})
    void 높이가_1_미만일_때_예외_발생(final int invalidHeight) {
      assertThatThrownBy(() -> new Ladder(4, invalidHeight))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 높이가_0일_때_예외_발생() {
      assertThatThrownBy(() -> new Ladder(3, 0))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 높이가_음수일_때_예외_발생() {
      assertThatThrownBy(() -> new Ladder(4, -2))
          .isInstanceOf(RuntimeException.class);
    }
  }
}