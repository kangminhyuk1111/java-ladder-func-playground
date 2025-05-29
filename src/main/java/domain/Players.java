package domain;

import java.util.Iterator;
import java.util.List;

public record Players(List<Player> players) implements Iterable<Player> {

  public Players {
    validatePlayers(players);
  }

  public int findPlayerIndexByName(final Player player) {
    if (player == null) {
      throw new RuntimeException("검색할 플레이어는 null일 수 없습니다.");
    }
    return players.indexOf(player);
  }

  public int size() {
    return players.size();
  }

  @Override
  public Iterator<Player> iterator() {
    return players.iterator();
  }

  private void validatePlayers(final List<Player> players) {
    if (players == null) {
      throw new RuntimeException("플레이어 목록은 null일 수 없습니다.");
    }
  }
}
