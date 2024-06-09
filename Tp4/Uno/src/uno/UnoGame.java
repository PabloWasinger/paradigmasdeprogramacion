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

    public UnoGame(ArrayList<ArrayList<String>> pile){
        int maze = 0;
        piles = new HashMap<Integer, ArrayList<Card>>();
       
        ArrayList<Card> center = new ArrayList<Card>();
        for (int i = 0; i < pile.size(); i=i+3) {
            Card card = new Card(pile.get(i));
            center.add(card);
        }

        ArrayList<Card> player1 = new ArrayList<Card>();
        for (int i = 1; i < pile.size(); i=i+3) {
            Card card = new Card(pile.get(i));
            player1.add(card);
        }

        ArrayList<Card> player2 = new ArrayList<Card>();
        for (int i = 2; i < pile.size(); i=i+3) {
            Card card = new Card(pile.get(i));
            player2.add(card);
        }
        piles.put(-1, center);
        piles.put(0, player1);
        piles.put(1, player2);
        this.jugada =  center.getLast();
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


//    protected String playCardCallUno(A){
//        this.playCard(card);
//        if (this.checkCards() == 1){
//            return "Uno";
//        }
//        else{
//            throw new RuntimeException("no podes gritar uno LACRA");
//        }
//
//    }



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
