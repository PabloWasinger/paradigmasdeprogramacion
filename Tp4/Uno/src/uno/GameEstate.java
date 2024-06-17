package uno;

import java.util.ArrayList;

abstract class GameEstate {
    protected UnoGame juego;
    protected ArrayList<Card> cartas;

    protected abstract void removeCard(Card card);

    public abstract void setLeft(GameEstate left);

    public abstract void setRight(GameEstate right);

    public abstract void takeCard(Card card);

    public abstract GameEstate getRight();

    public abstract GameEstate getLeft();

    protected abstract void hasCard(Card card);
}
