package uno;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;
import java.util.HashMap;

public class UnoGame {
    private HashMap<Integer, ArrayList<Card>> piles;
    private String sentido;
    private Integer turn;
    private Card jugada;

    public UnoGame(HashMap <Integer, ArrayList<Card>> pile){
        this.piles = pile;
        this.jugada = piles.get("center").getLast();
    }

    protected void reverse(){
        if (Objects.equals(sentido, "clockwise"))
        {
            sentido = "counter-clockwise";
        }
        else
        {
            sentido = "clockwise";
        }
    }
    protected void nextTurn(){
        if (Objects.equals(sentido, "counter-clockwise"))
        {
            turn = (turn + 1) % (piles.size()-1);
        }
        else
        {
            turn = (turn - 1) % (piles.size() -1);
        }
    }

    protected void takeCard(){piles.get(turn).add(piles.get(-1).getFirst());}
    protected void takeCard(int n){ // Take card para mas de una carta
        for (int i = 0; i < n; i++){
            takeCard();
        }
    }

    protected void playCard(Card card){
        jugada.playCard(card);
        piles.get(-1).add(card);
        jugada = card;
        if (this.checkCards() == 1){
            this.takeCard(2);
        }
        if (this.checkCards() == 0){
            this.gameOver();
        }
        this.nextTurn();

    }
    protected String playCardCallUno(Card card){
        jugada.playCard(card);
        jugada = card;
        if (this.checkCards() == 1){
            return "Uno";
        }
        else{
            throw new RuntimeException("no podes gritar uno LACRA");
        }

    }



    protected int checkCards(){
        return piles.get(turn).size();
    }
    protected void gameOver() {
        throw new RuntimeException("Game Over");
    }

    protected int turn(){
        return turn;
    }
    protected String sentido(){
        return sentido;
    }


    public Card getJugada(){        return jugada;
    }

}
