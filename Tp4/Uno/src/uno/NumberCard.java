package uno;

import java.util.Objects;

public class NumberCard extends Card {

    private int number;

    public NumberCard(int number, String color){
        super(color);
        this.number = number;
    }

    @Override
    protected void playCard(Card card, UnoGame uno) {
        this.goesOnTop(card);
        return;
    }

    @Override
    protected void goesOnTop(Card card) {

        if(card.goesUnderNumber(this.number) || card.goesUnderColor(this.color)){
            return;
        }

        throw new RuntimeException("Cannot play non-matching card");

    }

    @Override
    protected boolean goesUnderColor(String color) {
        return Objects.equals(this.color, color);
    }

    @Override
    protected boolean goesUnderNumber(int number) {
        return this.number == number;
    }

    @Override
    protected int getNumber(){
        return this.number;
    }

}
