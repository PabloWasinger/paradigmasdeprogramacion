package uno;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UnoGame {
    private Direction direction = new CounterClockwiseDirection();
    private ArrayList<Card> centerpile;
    private Card pitcard;
    private GameEstate estate;
    private int cantJugadores;


    public UnoGame(ArrayList<ArrayList<Card>> pile){

        this.centerpile = pile.getFirst();
        pile.removeFirst();



        ArrayList<GameEstate> estates = pile.stream()
                .map(p -> new PlayerTurn(this, p))
                .collect(Collectors.toCollection(ArrayList::new));
        int size = estates.size();
        for (int i = 0; i < estates.size(); i++){
            estates.get(i).setRight(estates.get((i+1)%(size)));
            estates.get(i).setLeft(estates.get((i - 1 + size) % size));
        }

        cantJugadores = size;

        estate = estates.getFirst();

        this.pitcard = centerpile.getLast();
        pitcard.playCard(pitcard,this);
    }
    protected void reverse(){
        if (cantJugadores == 2){
            this.nextTurn();
            return;
        }
        direction = direction.changeDirection();
    }

    protected void nextTurn(){
        direction.nextPlayer(this);
    }

    protected void nextTurnRight(){
        estate = estate.getRight();
    }

    protected void nextTurnLeft(){
        estate = estate.getLeft();
    }


    protected UnoGame takeCard(){
        estate.takeCard(centerpile.getFirst());
        centerpile.removeFirst();
        direction.nextPlayer(this);
        return this;
    }
    protected void takeCard(int n){ // Take card para mas de una carta
        for (int i = 0; i < n; i++){
            estate.takeCard(centerpile.getFirst());
            centerpile.removeFirst();
        }
    }

    protected UnoGame playCard(Card card){
        playCardInnerLogic(card);
        // si no grito 1
        int size = this.checkCards();
        if (size == 1){
            this.takeCard(2);
            this.nextTurn();
        }

        //si no tiene cartas
        else if (size == 0){
            this.gameOver();
        }
        else{
            this.nextTurn();
        }
        return this;

    }

    protected UnoGame playCardCallUno(Card card){
        playCardInnerLogic(card);
        this.nextTurn();
        return this;
    }


    private void playCardInnerLogic(Card card) {
        estate.hasCard(card);
        card.playCard(pitcard,this);
        centerpile.add(card);
        pitcard = card;
        estate.removeCard(card);
    }


    protected int checkCards(){
        return estate.cartas.size();
    }
    protected void gameOver() {
        this.estate = new GameOverEstate();
    }

    public String getColor(){
        return pitcard.getColor();
    }

    public int getNumber(){
        return pitcard.getNumber();
    }

}