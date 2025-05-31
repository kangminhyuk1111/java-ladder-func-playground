package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    private Players players;
    private Rewards rewards;

    @BeforeEach
    void setUp() {
        this.players = new Players(Stream.of("kang", "min", "hyuk").map(Player::new).toList());
        this.rewards = new Rewards(List.of("1000", "2000", "꽝"));
    }

    @Test
    void 정상적인_인덱스_결과_조회() {
        Map<Integer, Integer> results = new HashMap<>();
        results.put(0, 2);
        results.put(1, 0);
        results.put(2, 3);
        results.put(3, 1);

        LadderResult ladderResult = new LadderResult(results, players, rewards);

        assertThat(ladderResult.getResult(0)).isEqualTo(2);
        assertThat(ladderResult.getResult(1)).isEqualTo(0);
        assertThat(ladderResult.getResult(2)).isEqualTo(3);
        assertThat(ladderResult.getResult(3)).isEqualTo(1);
    }

    @Test
    void 존재하지_않는_인덱스_조회() {
        Map<Integer, Integer> results = Map.of(0, 1, 1, 0);
        LadderResult ladderResult = new LadderResult(results, players, rewards);

        assertThatThrownBy(() -> ladderResult.getResult(2)).isInstanceOf(RuntimeException.class);
    }
}