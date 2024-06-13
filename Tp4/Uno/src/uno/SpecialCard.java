package uno;

import java.util.Objects;

public abstract class SpecialCard extends Card {

    public SpecialCard(){
        super("wild");
    }

    public SpecialCard(String color){
        super(color);
    }

   protected abstract void playCard(Card card, UnoGame uno);

    @Override
    protected void matchCard(Card card) {
        if(this.getColor()!= card.getColor()){
            throw new RuntimeException("No se puede jugar esta carta");
        }
    }


    @Override
    protected int getNumber() {
        return -1;
    }
}
