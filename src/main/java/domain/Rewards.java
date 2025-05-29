package domain;

import java.util.List;

public record Rewards(List<String> rewards) {

  public String getReward(final int index) {
    return rewards.get(index);
  }
}
