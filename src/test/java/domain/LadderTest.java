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

      Ladder ladder = Ladder.testOf(width, height, () -> true);

      assertThat(ladder.lines()).hasSize(height);
      assertThat(ladder.lines()).isNotNull();

      for (Line line : ladder.lines()) {
        assertThat(line.size()).isEqualTo(width - 1);
      }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    void 다양한_높이_사다리_생성(final int height) {
      int width = 4;

      Ladder ladder = Ladder.testOf(width, height, () -> true);

      assertThat(ladder.lines()).hasSize(height);
    }

    @Test
    void 최소_크기_사다리_생성() {
      Ladder ladder = Ladder.testOf(2, 1, () -> true);

      assertThat(ladder.lines()).hasSize(1);
      assertThat(ladder.lines().get(0).size()).isEqualTo(1);
    }
  }

  @Nested
  @DisplayName("사다리 생성 테스트 - 실패 케이스")
  class FailureLadderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, -5, -10})
    void 폭이_2_미만일_때_예외_발생(final int invalidWidth) {
      assertThatThrownBy(() -> Ladder.testOf(invalidWidth, 5, () -> true))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 폭이_0일_때_예외_발생() {
      assertThatThrownBy(() -> Ladder.testOf(0, 3, () -> true))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 폭이_음수일_때_예외_발생() {
      assertThatThrownBy(() -> Ladder.testOf(-3, 5, () -> true))
          .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -10})
    void 높이가_1_미만일_때_예외_발생(final int invalidHeight) {
      assertThatThrownBy(() -> Ladder.testOf(4, invalidHeight, () -> true))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 높이가_0일_때_예외_발생() {
      assertThatThrownBy(() -> Ladder.testOf(3, 0, () -> true))
          .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 높이가_음수일_때_예외_발생() {
      assertThatThrownBy(() -> Ladder.testOf(4, -2, () -> true))
          .isInstanceOf(RuntimeException.class);
    }
  }
}