package domain;

import java.util.Objects;

public record Player(String name) {

  public Player {
    validateName(name);
  }

  private void validateName(final String name) {
    if (name.length() >= 5) {
      throw new RuntimeException("이름은 5글자를 초과할 수 없습니다.");
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

}
