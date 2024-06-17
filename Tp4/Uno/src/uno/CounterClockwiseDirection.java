package uno;

public class CounterClockwiseDirection extends Direction{
    @Override
    protected Direction changeDirection() {return new ClockwiseDirection();}

    @Override
    protected void nextPlayer(UnoGame game) {game.nextTurnRight();}
}
