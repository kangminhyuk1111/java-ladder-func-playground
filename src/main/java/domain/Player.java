package domain;

public record Player(String name) {

  public Player {
    validateName(name);
  }

  private void validateName(final String name) {
    if (name.length() > 5) {
      throw new RuntimeException("이름은 5글자를 초과할 수 없습니다.");
    }
  }
}
