package uno;

public class ClockwiseDirection extends Direction{
    @Override
    protected Direction changeDirection() {
        return new CounterClockwiseDirection();
    }
    @Override
    protected void nextPlayer(UnoGame game) {game.nextTurnLeft();    }
}
