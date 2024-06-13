package uno;

public abstract class Card1 {
    String color;
    public Card1(String color){
        this.color = color;
    }
    protected String Calluno(){return "uno";}

    protected abstract void playCard(Card1 card, UnoGame uno);
    protected abstract void matchCard(Card1 card);
    protected abstract Boolean sameCard(Card1 card);

    protected abstract int getNumber();
    protected String getColor(){
        return this.color;
    }
}
