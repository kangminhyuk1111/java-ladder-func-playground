package domain;

import java.util.Map;

public record LadderResult(Map<Integer, Integer> results) {

  public int getResult(int index) {
    if (results.get(index) == null) {
      throw new RuntimeException("값이 존재하지 않습니다.");
    }
    return results.get(index);
  }
}
