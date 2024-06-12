package uno;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UnoGame {
    private HashMap<Integer, ArrayList<Card>> piles;
    private String sentido = "counter-clockwise";
    private Integer turn = 0;
    private Card jugada;

    public UnoGame(ArrayList<ArrayList<Card1>> pile){
        pile.stream().forEach((p) -> {
            piles.put(pile.indexOf(p) - 1, p);
        });
        this.jugada =  piles.get(-1).getLast();
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
            turn = (turn + piles.size()-1) % (piles.size() -1);
        }
    }

    protected UnoGame takeCard(){
        piles.get(turn).add(piles.get(-1).getFirst());
        this.nextTurn();
        return this;
    }
    protected void takeCard(int n){ // Take card para mas de una carta
        for (int i = 0; i < n; i++){
            takeCard();
        }
    }

    protected UnoGame playCard(String color, String number, String type){
        Card card = new Card(new ArrayList<String>(Arrays.asList(color, number, type)));
        card.playCard(jugada);
        piles.get(-1).add(card);
        jugada = card;
        ArrayList<Card> carton = (ArrayList<Card>) piles.get(turn).stream().filter((car) -> car.sameCard(card)).collect(Collectors.toList());
        piles.get(turn).remove(carton.getFirst());

        // si no grito 1
        if (this.checkCards() == 1){
            this.takeCard(2);
        }

        //si no tiene cartas
        if (this.checkCards() == 0){
            this.gameOver();
        }
        this.nextTurn();
        return this;

    }

    protected UnoGame playCard(Card1 card, String uno){

        return this;
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


    public Card getJugada(){return jugada;
    }

    public String getColor(){
        return jugada.getColor();
    }

    public String getNumber(){
        return jugada.getNumber();
    }

}
