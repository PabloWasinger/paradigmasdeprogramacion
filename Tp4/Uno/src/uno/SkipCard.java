package uno;

public class SkipCard extends SpecialCard{


    public SkipCard(String color) {
        super(color);
    }

    @Override
    protected void playCard(Card card, UnoGame uno) {
        this.goesOnTop(card);
        uno.nextTurn();
    }

    @Override
    protected void goesOnTop(Card card) {

        if(card.goesUnderSkip() || card.goesUnderColor(this.color)){
            return;
        }

        throw new RuntimeException("Cannot play non-matching card");

    }

    @Override
    protected boolean goesUnderSkip() {
        return true;
    }


}
