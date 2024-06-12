package uno;

public class NumberCard extends Card1{

    private int number;

    public NumberCard(int number, String color){
        super(color);
        this.number = number;
    }

    @Override
    protected void playCard(Card1 card, UnoGame uno) {
        this.matchCard(card);
        return;
    }

    @Override
    protected void matchCard(Card1 card) {
        if (this.number == card.getNumber()){
            return;
        }
        else if (this.getColor().equals(card.getColor())){
            return;
        }
        throw new RuntimeException("Cannot play non-matching card");

    }

    @Override
    protected Boolean sameCard(Card1 card) {
        return null;
    }

    @Override
    protected int getNumber(){
        return this.number;
    }
}
