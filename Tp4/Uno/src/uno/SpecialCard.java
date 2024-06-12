package uno;

import java.util.Objects;

public abstract class SpecialCard extends Card1{

    public SpecialCard(){
        super("wild");
    }

    public SpecialCard(String color){
        super(color);
    }

   protected abstract void playCard(Card1 card, UnoGame uno);

    @Override
    protected void matchCard(Card1 card) {
        if(Objects.equals(this.getColor(), card.getColor())){
            return;
        }
    }

    @Override
    protected Boolean sameCard(Card1 card) {
        return this.equals(card);
    }

    @Override
    protected int getNumber() {
        return -1;
    }
}
