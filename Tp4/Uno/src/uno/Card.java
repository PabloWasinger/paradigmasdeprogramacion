package uno;

public abstract class Card {
    String color;

    public Card(String color){
        this.color = color;
    }

    protected abstract void playCard(Card card, UnoGame uno);
    protected abstract void goesOnTop(Card card);
    protected abstract boolean goesUnderColor(String color);
    protected abstract boolean goesUnderNumber(int number);


    protected abstract int getNumber();

    protected boolean goesUnderReverse() {
        return false;
    }
    protected boolean goesUnderSkip() {return false;}

    protected boolean goesUnderDrawTo() {
        return false;
    }

    protected Boolean sameCard(Card card) {
        return this.equals(card);
    }


    public String getColor() {
        return this.color;
    }


}
