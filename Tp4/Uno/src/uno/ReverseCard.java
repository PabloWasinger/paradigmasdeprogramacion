package uno;

public class ReverseCard extends SpecialCard{

    public ReverseCard(String color) {
        super(color);
    }
    @Override
    protected void playCard(Card card, UnoGame uno) {
        this.matchCard(card);
        uno.reverse();
    }

}
