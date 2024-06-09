package uno;
import java.util.Objects;
import java.util.ArrayList;

public class Card {

    private String color;
    private String number;
    private String type;

    
    public Card(ArrayList<String> carta){
        this.color = carta.get(0);
        this.number = carta.get(1);
        this.type = carta.get(2);
    }

    protected void playCard(Card card){
        if (Objects.equals(this.type, "wild")){
            throw new RuntimeException("Wild card must have color");
        }
        this.matchCard(card);
    }

    protected Card playCard(Card card, String color, UnoGame game){
        if (Objects.equals(this.type, "wild")){
            this.changeColorTo(color);
        }
        this.matchCard(card);
        if (Objects.equals(card.type, "skip")){
            this.skip(game);
        }
        return this;
    }


    protected void matchCard(Card card){
        if (this.matchesColorWith(card) || this.matchesNumberWith(card)){
            return;
        }
        throw new RuntimeException("Cannot play non-matching card");
    }
    protected boolean matchesColorWith(Card card){
        if (Objects.equals(this.type, "wild"))
        {
            return true ;
        }
        else if (Objects.equals(this.color, card.color)) {
            return true;
        }
        return false;

    }

    protected boolean matchesNumberWith(Card card){
        if (this.isSpecial())
        {
            return true;
        }
        else if (card.isSpecial())
        {
            return true;
        }

        else if (Objects.equals(this.number, card.number)) {
            return true;
        }
        return false;
    }
    protected boolean isSpecial(){
        return !Objects.equals(this.type, "numbered");
    }

    protected Card changeColorTo(String color){
            this.color = color;
            return this;
    }


    protected void reverse(UnoGame game, int jugadores){
        if (jugadores == 2){
            game.nextTurn();
            game.reverse();
        }
        game.reverse();


    }

    protected void skip(UnoGame game){
        game.nextTurn();
    }

    protected void drawTwo(UnoGame game){
        game.takeCard(2);
    }

    protected Boolean sameCard(Card card){
        return this.number.equals(card.getNumber()) && this.color.equals(card.getColor());
    }

    public String getColor(){
        return this.color;
    }

    public String getNumber(){
        return this.number;
    }
}
