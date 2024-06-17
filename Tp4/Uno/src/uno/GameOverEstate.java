package uno;
public class GameOverEstate extends GameEstate{

    private void throwGameOverException() {
        throw new RuntimeException("Game is over");
    }

    @Override
    protected void removeCard(Card card) {
        throwGameOverException();
    }

    @Override
    public void setLeft(GameEstate left) {
        throwGameOverException();
    }

    @Override
    public void setRight(GameEstate right) {
        throwGameOverException();
    }

    @Override
    public void takeCard(Card card) {
        throwGameOverException();

    }

    @Override
    public GameEstate getRight() {
        throwGameOverException();
        return null;
    }

    @Override
    public GameEstate getLeft() {
        throwGameOverException();
        return null;
    }

    @Override
    protected void hasCard(Card card) {
        throwGameOverException();
    }
}