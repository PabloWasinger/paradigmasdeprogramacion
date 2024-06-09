package uno;
import java.util.Objects;

public class Card {

    private String color;
    private int number;
    private String type;

    
    public Card(String color, String type){
        this.color = color;
        this.type = type;

    }
    public Card(String color, int number){
        this.color = color;
        this.number = number;
        this.type = "numbered";
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
}
