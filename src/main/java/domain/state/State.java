package domain.state;

import domain.Card;

import java.util.List;

public interface State {
    State draw(Card card);

    State stand();

    int score();

    double profitRate(State state);

    boolean isBust();

    boolean isBlackjack();

    List<Card> hand();
}
