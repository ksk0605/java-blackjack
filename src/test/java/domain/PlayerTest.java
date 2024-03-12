package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class PlayerTest {
    public static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(new Card(Denomination.KING, Suit.CLUBS), new Card(Denomination.KING, Suit.HEART),
                                new Card(Denomination.KING, Suit.SPADE)), false),
                Arguments.of(
                        List.of(new Card(Denomination.FIVE, Suit.CLUBS), new Card(Denomination.FOUR, Suit.HEART),
                                new Card(Denomination.THREE, Suit.SPADE)), true)
        );
    }

    @Test
    @DisplayName("플레이어는 자신이 갖는 카드 합계를 계산할 수 있다")
    void sum() {
        final Player player = new Player(new Name("지쳐버린종이"));

        player.dealCard(new Card(Denomination.FIVE, Suit.CLUBS));
        player.dealCard(new Card(Denomination.FIVE, Suit.CLUBS));
        player.dealCard(new Card(Denomination.ACE, Suit.CLUBS));

        Assertions.assertThat(player.score()).isEqualTo(21);
    }

    @Test
    @DisplayName("플레이어는 자신이 갖는 카드 합계를 계산할 수 있다")
    void sum2() {
        final Player player = new Player(new Name("지쳐버린종이"));

        player.dealCard(new Card(Denomination.KING, Suit.CLUBS));
        player.dealCard(new Card(Denomination.KING, Suit.CLUBS));
        player.dealCard(new Card(Denomination.ACE, Suit.CLUBS));

        Assertions.assertThat(player.score()).isEqualTo(21);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    @DisplayName("플레이어의 버스트 여부를 반환한다.")
    void alive(final List<Card> cards, final boolean expected) {
        final Player player = new Player(new Name("지쳐버린종이"));

        player.dealCard(cards.get(0));
        player.dealCard(cards.get(1));
        player.dealCard(cards.get(2));

        Assertions.assertThat(player.isNotBust()).isEqualTo(expected);
    }
}
