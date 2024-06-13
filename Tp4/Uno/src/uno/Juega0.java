package uno;

import java.util.ArrayList;

public class Juega0 extends Estado {
    public Juega0(UnoGame juego){
        super();
        this.juego = juego;
        this.turn = 0;
        this.mazo = juego.piles.get(turn);
    }

    @Override
    protected Estado nextTurn() {
        return new Juega1(juego);
    }
}
