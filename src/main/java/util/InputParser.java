package util;

import domain.Player;
import domain.Players;
import domain.Rewards;
import java.util.Arrays;

public class InputParser {

  private InputParser() {
  }

  public static Players parsePlayers(String players) {
    return new Players(Arrays.stream(players.split(","))
        .map(Player::new)
        .toList());
  }

  public static Rewards parseRewards(String rewards) {
    return new Rewards(Arrays.stream(rewards.split(","))
        .toList());
  }

  public static Player parsePlayer(String player) {
    return new Player(player);
  }

}
