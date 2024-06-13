package uno;

public abstract class Card {
    String color;
    public Card(String color){
        this.color = color;
    }
    protected String Calluno(){return "uno";}

    protected abstract void playCard(Card card, UnoGame uno);
    protected abstract void matchCard(Card card);

    protected Boolean sameCard(Card card) {
        return this.equals(card);
    }

    protected abstract int getNumber();
    protected String getColor(){
        return this.color;
    }
}
