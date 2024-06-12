package uno;

public class WildCard extends SpecialCard{


    public WildCard() {
        super();
    }

    @Override
    protected void playCard(Card1 card, UnoGame uno){
        return;
    }
    protected void beRed(){this.color = "red";}
    protected void beBlue(){this.color = "blue";}
    protected void beGreen(){this.color = "green";}
    protected void beYellow(){this.color = "yellow";}


}
