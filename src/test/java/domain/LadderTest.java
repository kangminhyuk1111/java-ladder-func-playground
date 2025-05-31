package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.ArrayList;
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
      List<Line> lines = createTestLines(width - 1, height);

      Ladder ladder = Ladder.of(lines);

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
      List<Line> lines = createTestLines(width - 1, height);

      Ladder ladder = Ladder.of(lines);

      assertThat(ladder.lines()).hasSize(height);
    }

    @Test
    void 최소_크기_사다리_생성() {
      List<Line> lines = List.of(new Line(List.of(true)));

      Ladder ladder = Ladder.of(lines);

      assertThat(ladder.lines()).hasSize(1);
      assertThat(ladder.lines().get(0).size()).isEqualTo(1);
    }

    private List<Line> createTestLines(int connectionCount, int height) {
      List<Line> lines = new ArrayList<>();
      List<Boolean> connections = new ArrayList<>();

      for (int i = 0; i < connectionCount; i++) {
        connections.add(i % 2 == 0);
      }

      for (int i = 0; i < height; i++) {
        lines.add(new Line(connections));
      }
      return lines;
    }
  }

  @Nested
  @DisplayName("사다리 생성 테스트 - 실패 케이스")
  class FailureLadderTest {

    @Test
    void 빈_라인_리스트일_때_예외_발생() {
      List<Line> emptyLines = List.of();

      assertThatThrownBy(() -> Ladder.of(emptyLines))
              .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 폭이_너무_작을_때_예외_발생() {
      List<Line> lines = List.of(new Line(List.of()));

      assertThatThrownBy(() -> Ladder.of(lines))
              .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 라인들의_폭이_다를_때_예외_발생() {
      List<Line> lines = List.of(
              new Line(List.of(true, false)),
              new Line(List.of(false))
      );

      assertThatThrownBy(() -> Ladder.of(lines))
              .isInstanceOf(RuntimeException.class);
    }
  }
}