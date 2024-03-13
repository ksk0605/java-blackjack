package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class PlayersTest {

    @DisplayName("플레이어 수가 8명 초과하면 예외를 발생한다")
    @Test
    void playerSize() {
        final List<Player> players = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            players.add(new Player(new Name("teba" + i)));
        }

        assertThatCode(() -> new Players(players)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 이름이 겹치면 예외가 발생한다")
    @Test
    void duplicateName() {
        final List<Player> players = new ArrayList<>();

        players.add(new Player(new Name("teba")));
        players.add(new Player(new Name("teba")));

        assertThatCode(() -> new Players(players)).isInstanceOf(IllegalArgumentException.class);
    }
}
