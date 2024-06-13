package uno;

public class WildCard extends SpecialCard{


    public WildCard() {
        super();
    }

    @Override
    protected void playCard(Card card, UnoGame uno){
        return;
    }
    protected Card beRed(){this.color = "red";
    return this;}
    protected Card beBlue(){this.color = "blue";
        return this;}
    protected Card beGreen(){this.color = "green";
        return this;}
    protected Card beYellow(){this.color = "yellow";
        return this;}


}
