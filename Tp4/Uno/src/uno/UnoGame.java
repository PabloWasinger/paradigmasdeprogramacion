package uno;

import java.util.ArrayList;
import java.util.Objects;

public class UnoGame {
    private ArrayList <ArrayList<Card>> piles;
    private ArrayList<Integer> turnes;

    private String sentido;
    private Integer turn;
    private Card jugada;



    protected void nextTurn(){
        if (Objects.equals(sentido, "clockwise"))
        {
            turn = (turn + 1) % turnes.size();
        }
        else
        {
            turn = (turn - 1) % turnes.size();
        }
    }

    protected void takeCard(){
        piles.get(turn).add(piles.getLast().get(0));
        piles.removeLast();
    }

    protected void playCard(Card card){
        jugada.playCard(card);
        jugada = card;
        this.nextTurn();

    }
    protected String playCardCallUno(Card card){
        jugada.playCard(card);
        jugada = card;
        if (Objects.equals(piles.get(turn).size(),1)){
            return "Uno";
        }
        throw new RuntimeException("no podes gritar uno LACRA");
    }



}
