package uno;
import java.util.Objects;

public class Card {

    private String color;
    private int number;
    private String type;


    protected void playCard(Card card){
        if (Objects.equals(this.type, "wild")){
            throw new RuntimeException("Wild card must have color");
        }
        this.matchCard(card);
    }

    protected void playCard(Card card, String color){
        if (Objects.equals(this.type, "wild")){
            this.changeColorTo(color);
        }
        this.matchCard(card);
    }


    protected void matchCard(Card card){
        this.matchesColorWith(card);
        this.matchesNumberWith(card);
    }
    protected void matchesColorWith(Card card){
        if (Objects.equals(this.type, "wild"))
        {
            return;
        }
        else if (Objects.equals(this.color, card.color)) {
            return;
        }
        throw new RuntimeException("Cannot play non-matching card");

    }

    protected void matchesNumberWith(Card card){
        if (this.isSpecial())
        {
            return;
        }
        else if (card.isSpecial())
        {
            return;
        }

        else if (Objects.equals(this.number, card.number)) {
            return;
        }
        throw new RuntimeException("Cannot play non-matching card");
    }
    protected boolean isSpecial(){
        return Objects.equals(this.type, "numbered");
    }

    protected Card changeColorTo(String color){
            this.color = color;
            return this;
    }
}
