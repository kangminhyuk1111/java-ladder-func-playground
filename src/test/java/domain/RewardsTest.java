package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RewardsTest {

  @Test
  void 보상_목록이_정상적으로_생성된다() {
    List<String> rewardList = List.of("꽝", "5000", "3000");

    Rewards rewards = new Rewards(rewardList);

    assertThat(rewards.getReward(0)).isEqualTo("꽝");
  }

  @Test
  void 인덱스로_보상을_조회할_수_있다() {
    List<String> rewardList = List.of("꽝", "5000", "3000");
    Rewards rewards = new Rewards(rewardList);

    String reward = rewards.getReward(1);

    assertThat(reward).isEqualTo("5000");
  }
}