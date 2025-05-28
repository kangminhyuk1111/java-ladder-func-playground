package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BooleanGeneratorTest {

  @Test
  void 항상_true_반환() {
    BooleanGenerator alwaysTrue = () -> true;

    for (int i = 0; i < 10; i++) {
      assertThat(alwaysTrue.nextBoolean()).isTrue();
    }
  }

  @Test
  void 항상_false_반환() {
    BooleanGenerator alwaysFalse = () -> false;

    for (int i = 0; i < 10; i++) {
      assertThat(alwaysFalse.nextBoolean()).isFalse();
    }
  }
}