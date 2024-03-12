package domain;

import dto.GameResult;

import java.util.List;

public class Blackjack {
    public static final int INITIAL_HAND_SIZE = 2;
    private final Players players;
    private final Dealer dealer;

    public Blackjack(final Players players, final Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        initGame();
    }

    private void initGame() {
        initPlayers();
        initDealer();
    }

    private void initPlayers() {
        for (final Player player : players.getPlayers()) {
            player.dealCards(dealer.drawCards(INITIAL_HAND_SIZE));
        }
    }

    private void initDealer() {
        dealer.dealCards(dealer.drawCards(INITIAL_HAND_SIZE));
    }

    public void dealCard(final Player player) {
        player.dealCard(dealer.drawSingleCard());
    }

    public GameResult finishGame() {
        final BlackjackRule blackjackRule = new BlackjackRule();
        return blackjackRule.calculate(players, dealer);
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public Dealer getDealer() {
        return dealer;
    }
}
