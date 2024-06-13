package uno;

public class NumberCard extends Card {

    private int number;

    public NumberCard(int number, String color){
        super(color);
        this.number = number;
    }

    @Override
    protected void playCard(Card card, UnoGame uno) {
        this.matchCard(card);
        return;
    }

    @Override
    protected void matchCard(Card card) {
        if (this.number == card.getNumber()){
            return;
        }
        else if (this.getColor().equals(card.getColor())){
            return;
        }
        throw new RuntimeException("Cannot play non-matching card");

    }


    @Override
    protected int getNumber(){
        return this.number;
    }
}
