package uno;

public abstract class Direction {
    protected abstract Direction changeDirection();
    protected abstract void nextPlayer(UnoGame game);
}
