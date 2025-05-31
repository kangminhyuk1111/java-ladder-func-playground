package domain;

import java.util.Map;

public record LadderResult(Map<Integer, Integer> results, Players players, Rewards rewards) {

    public String getReward(final String targetPlayerInput) {
        final Player player = new Player(targetPlayerInput);
        final int playerIndex = players.findPlayerIndexByName(player);

        final int resultIndex = getResult(playerIndex);

        return rewards.getReward(resultIndex);
    }

    public int getResult(int index) {
        if (results.get(index) == null) {
            throw new RuntimeException("값이 존재하지 않습니다.");
        }
        return results.get(index);
    }

    @Override
    public Map<Integer, Integer> results() {
        return results;
    }

    @Override
    public Players players() {
        return players;
    }

    @Override
    public Rewards rewards() {
        return rewards;
    }
}
