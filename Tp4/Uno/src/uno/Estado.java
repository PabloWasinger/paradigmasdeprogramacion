package uno;

import java.util.ArrayList;

abstract class Estado {
    protected UnoGame juego;
    protected int turn;
    protected ArrayList<Card> mazo;
    protected abstract Estado nextTurn();

}
