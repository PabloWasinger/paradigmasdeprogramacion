package uno;

public class DrawTwoCard extends SpecialCard{

    public DrawTwoCard(String color) {
        super(color);
    }

    @Override
    protected void playCard(Card1 card, UnoGame uno) {
        this.matchCard(card);
        uno.takeCard(2);

    }

}
