package uno;

public class ReverseCard extends SpecialCard{

    public ReverseCard(String color) {
        super(color);
    }
    @Override
    protected void playCard(Card card, UnoGame uno) {
        this.goesOnTop(card);
        uno.reverse();
    }

    @Override
    protected void goesOnTop(Card card) {

        if(card.goesUnderReverse() || card.goesUnderColor(this.color)){
            return;
        }

        throw new RuntimeException("Cannot play non-matching card");

    }

    @Override
    protected boolean goesUnderReverse() {
        return true;
    }


}
