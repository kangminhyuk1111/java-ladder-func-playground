package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

  @ParameterizedTest
  @ValueSource(ints = {2, 3, 4, 5, 10})
  void 라인_생성_테스트(final int width) {
    // given
    BooleanGenerator generator = () -> false;

    // when
    final Line line = new Line(width, generator);

    // then
    assertThat(line.size()).isEqualTo(width - 1);
    assertThat(line).isNotNull();
  }

  @Test
  void 모든_연결이_true인_경우_연속_방지() {
    BooleanGenerator generatorTrue = () -> true;

    Line line = new Line(4, generatorTrue);

    assertThat(line.isConnected(0)).isTrue();
    assertThat(line.isConnected(1)).isFalse();
    assertThat(line.isConnected(2)).isTrue();
  }

  @Test
  void 모든_연결이_false인_경우() {
    BooleanGenerator alwaysFalse = () -> false;

    Line line = new Line(4, alwaysFalse);

    for (int i = 0; i < line.size(); i++) {
      assertThat(line.isConnected(i)).isFalse();
    }
  }

  @Test
  void 인덱스_범위_초과_예외_테스트() {
    // given
    BooleanGenerator generator = () -> false;
    final Line line = new Line(4, generator);

    // when & then
    assertThatThrownBy(() -> line.isConnected(-1))
        .isInstanceOf(IndexOutOfBoundsException.class);

    assertThatThrownBy(() -> line.isConnected(line.size()))
        .isInstanceOf(IndexOutOfBoundsException.class);
  }
}