package uno;

public class SkipCard extends SpecialCard{


    public SkipCard(String color) {
        super(color);
    }

    @Override
    protected void playCard(Card1 card, UnoGame uno) {
        this.matchCard(card);
        uno.nextTurn();
    }




}
