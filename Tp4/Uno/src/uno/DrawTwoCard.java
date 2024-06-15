package uno;

import java.util.Objects;

public class DrawTwoCard extends SpecialCard{

    public DrawTwoCard(String color) {
        super(color);
    }

    @Override
    protected void playCard(Card card, UnoGame uno) {
        this.matchCard(card);
        uno.takeCard(2);

    }

    @Override
    protected void matchCard(Card card) {

        if(card.goesUnderDrawTo() || card.goesUnderColor(this.color)){
            return;
        }

        throw new RuntimeException("Cannot play non-matching card");

    }

    @Override
    protected boolean goesUnderDrawTo() {
        return true;
    }

}
