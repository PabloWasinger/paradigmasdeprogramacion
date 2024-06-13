package uno;

public class Juega1 extends Estado {
    public Juega1(UnoGame juego) {
        super();
        this.juego = juego;
        this.turn = 1;
        this.mazo = juego.piles.get(turn);
    }

    @Override
    protected Estado nextTurn() {
        return new Juega0(juego);
    }
}
