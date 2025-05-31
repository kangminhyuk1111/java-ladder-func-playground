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
                .map(player -> new Player(player.trim()))
                .toList());
    }

    public static Rewards parseRewards(String rewards) {
        return new Rewards(Arrays.stream(rewards.split(","))
                .map(String::trim)
                .toList());
    }
}
