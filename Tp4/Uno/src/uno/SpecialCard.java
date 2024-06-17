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

    protected abstract void goesOnTop(Card card);
    protected boolean goesUnderNumber(int number){
        return false;
    }

    protected boolean goesUnderColor(String color){
        return Objects.equals(this.color, color);
    }

    protected int getNumber(){
        throw new RuntimeException("Card does not have a number");
    }

}
