package uno;

import java.util.ArrayList;

public class PlayerTurn extends GameEstate {
    private GameEstate right;
    private GameEstate left;

    public PlayerTurn(UnoGame juego, ArrayList<Card> cartas) {
        super();
        this.juego = juego;
        this.cartas = cartas;
    }

    @Override
    public void takeCard(Card card) {
        this.cartas.add(card);
    }

    public void setRight(GameEstate right){
        this.right = right;
    }

    public void setLeft(GameEstate left){
        this.left = left;
    }
    public GameEstate getRight() {
        return right;
    }

    public GameEstate getLeft() {
        return left;
    }

    protected void removeCard(Card card){
        cartas.remove(card);
    }


    protected void hasCard(Card card){
        if(!cartas.contains(card)){
            throw new RuntimeException("Player does not have card");
        }
    }
}
