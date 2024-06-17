package uno;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UnoTest {

    @Test
    void tesPitCardStartsBlue(){
        assertEquals("azul", newGameWithTwoReverseCardsForPlayer1().getColor());
    }

    @Test void testPitCardStarts1(){
        assertEquals(2, newGameWithTwoReverseCardsForPlayer1().getNumber());
    }


    @Test void testPlayerDiscardCardsCorrectlyIfItIsMatchingColor(){
        assertEquals("azul", newGameWithTwoReverseCardsForPlayer1().playCard(azul1).getColor());
    }

    @Test void testPlayerDiscardCardsCorrectlyIfItIsMatchingNumber(){
        assertEquals("rojo", newGameWithTwoReverseCardsForPlayer1().playCard(rojo2).getColor());

    }

    @Test void testCannotPLayCardPLayerDoesNotHave(){
        assertThrowsLike("Player does not have card", () -> newGameWithTwoReverseCardsForPlayer1().playCard(azul2));
    }

    @Test void testCannotPlayNonMatchingCard(){
        assertThrowsLike("Cannot play non-matching card", () -> newGameWithTwoReverseCardsForPlayer1().playCard(verdeReverse));
    }


    @Test void testCanDrawCard(){
        assertEquals("rojo", newGameWithOneCardEachPlayer().takeCard().getColor());
    }
    @Test void testPlayer2CanPlayAfterPlayer1(){
        assertEquals("rojo", newGameWithTwoReverseCardsForPlayer1().playCard(rojo2).playCard(rojo3).getColor());
    }

    @Test void testPlayer2TurnIfPlayer1TakesCard(){
        assertEquals("azul", newGameWithTwoReverseCardsForPlayer1().takeCard().playCard(azul3).getColor());
    }

    @Test void testCantPlayCardWhenTheGameEnds(){
        assertThrowsLike("Game is over", () -> newGamePlayer1Win().playCard(rojo2).playCard(rojo3));
    }

    @Test void testCantTakeCardWhenTheGameEnds(){
        assertThrowsLike("Game is over", () -> newGamePlayer1Win().playCard(rojo2).takeCard());
    }

    @Test void testCanPlayCardShoutingUno(){
        assertEquals("azul", newSimpleGame().playCardCallUno(amarillo1).playCard(azul1).getColor());
    }
    @Test void testPlayerDrawsTwoCardsIfFailToShoutUno(){
        assertEquals("verde", newSimpleGame().playCard(amarillo1).playCard(azul1).playCard(azul2).playCard(azul3).playCard(verde3).getColor());
    }


    @Test void testCanPlayDrawedUpCard(){
        assertEquals("azul", newSimpleGame().takeCard().playCard(rojo2).playCard(azul2).getColor());
    }


    @Test void testPlayer1TurnAfterSkip(){
      assertEquals("azul", newGameWithTwoSkipCardsForPLayer1().playCard(azulSkip).
              playCard(azul6).getColor());
    }

    @Test void testReverseWorksAsSkipWhenTwoPlayers(){
        assertEquals("azul", newGameWithTwoReverseCardsForPlayer1().playCard(azulReverse).
                playCard(azul1).getColor());
    }

    @Test void testDrawTwoWorksCorrectly(){
        assertEquals("amarillo", newGameWIthTwoDrawTwoCardsForPlayer1().playCard(azulDrawTwo).
                playCard(azul1).playCard(amarillo1).getColor());
    }
    @Test void testWildCardBecomesYellow() {
        assertEquals("yellow", newGameWithWildCardForPlayer1().playCard(wild.beYellow()).getColor());
    }
    @Test void testWildCardBecomesBlue(){
        assertEquals("blue", newGameWithWildCardForPlayer1().playCard(wild.beBlue()).getColor());
    }
    @Test void testWildCardBecomesGreen(){
        assertEquals("green", newGameWithWildCardForPlayer1().playCard(wild.beGreen()).getColor());
    }
    @Test void testWildCardBecomesRed(){
        assertEquals("red", newGameWithWildCardForPlayer1().playCard(wild.beRed()).getColor());
    }


    @Test void testCanPlaySkipTwice(){
        assertEquals("verde", newGameWithTwoSkipCardsForPLayer1().playCard(azulSkip).
                playCard(verdeSkip).getColor());
    }

    @Test void testCanPlayReverseTwice(){
        assertEquals("verde", newGameWithTwoReverseCardsForPlayer1().playCard(azulReverse).
                playCard(verdeReverse).getColor());
    }

    @Test void testCanPlayDrawTwoTwice(){
        assertEquals("rojo", newGameWIthTwoDrawTwoCardsForPlayer1().playCard(azulDrawTwo).
                playCard(rojoDrawTwo).playCard(rojo1).playCard(rojo3).getColor());
    }


    @Test void testSimpleGameWithThreePlayers(){
        assertEquals("rojo", newGameThreePlayers().playCard(azul1).playCard(rojo1).playCard(rojo2).getColor());
    }

    @Test void testPlayer3TurnAfterPlayer2TakesCard(){
        assertEquals("azul", newGameThreePlayers().playCard(azul1).takeCard().playCard(azul3).getColor());
    }

    @Test void testPLayer3TurnAfterSkip(){
        assertEquals("azul", newGameThreePlayers().playCard(azulReverse).playCard(azul3).getColor());
    }

    @Test void testPlayer3TurnAfterDrawTwo(){
        assertEquals("azul", newGameThreePlayers().playCard(azulDrawTwo).playCard(azul3).getColor());
    }

    @Test void testPlayer3TurnAfterReverse(){
        assertEquals("azul", newGameThreePlayers().playCard(azulReverse).playCard(azul3).getColor());
    }



    private UnoGame newGame(ArrayList<ArrayList<Card>> pile){
        return new UnoGame(pile);}
    


    private UnoGame newGameWithOneCardEachPlayer() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(azul2, rojo1)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo2)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2)));
        return newGame(pile);
    }

    private UnoGame newSimpleGame() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(azul2, verde3,  rojo1)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo1, amarillo6)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2,azul3, azul1)));
        return newGame(pile);
    }

    private UnoGame newGameWithTwoReverseCardsForPlayer1() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(azul4, rojo1,azul2)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2,azul1,azulReverse,verdeReverse)));
        pile.add(new ArrayList<>(Arrays.asList(rojo3,azul3)));
        return newGame(pile);
    }

    private UnoGame newGameWIthTwoDrawTwoCardsForPlayer1() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(amarillo1,azulReverse,wild,verde2,azul2)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo2,rojo1,azulDrawTwo,azul1, rojoDrawTwo)));
        pile.add(new ArrayList<>(Arrays.asList(rojo3)));
        return newGame(pile);
    }


    private UnoGame newGamePlayer1Win() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(rojo1)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2)));
        pile.add(new ArrayList<>(Arrays.asList(rojo3)));
        return newGame(pile);
    }

    private UnoGame newGameWithTwoSkipCardsForPLayer1() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(rojo2,azul2 )));
        pile.add(new ArrayList<>(Arrays.asList(azulSkip,verdeSkip,azul6)));
        pile.add(new ArrayList<>(Arrays.asList(rojo5,azul1)));
        return newGame(pile);
    }


private UnoGame newGameWithWildCardForPlayer1() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(rojo1, rojo4)));
        pile.add(new ArrayList<>(Arrays.asList(wild, rojo3, azul2)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2, amarillo1, azul3)));
        return newGame(pile);
    }

    private UnoGame newGameThreePlayers() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(wild,verde2,amarillo1,azul2)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo2,azulDrawTwo,azul1, azulReverse, azulSkip)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo3, rojo1, azul3)));
        pile.add(new ArrayList<>(Arrays.asList(verdeDrawTwo,azul3, rojoSkip, rojo2)));
        return newGame(pile);
    }

    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }



    NumberCard rojo1 = new NumberCard(1, "rojo");
    NumberCard rojo2 = new NumberCard(2, "rojo");
    NumberCard rojo3 = new NumberCard(3, "rojo");
    NumberCard rojo4 = new NumberCard(4, "rojo");
    NumberCard rojo5 = new NumberCard(5, "rojo");


    NumberCard azul1 = new NumberCard(1, "azul");
    NumberCard azul2 = new NumberCard(2, "azul");
    NumberCard azul3 = new NumberCard(3, "azul");
    NumberCard azul4 = new NumberCard(4, "azul");
    NumberCard azul6 = new NumberCard(6, "azul");

    NumberCard verde2 = new NumberCard(2, "verde");
    NumberCard verde3 = new NumberCard(3, "verde");

    NumberCard amarillo1 = new NumberCard(1, "amarillo");
    NumberCard amarillo2 = new NumberCard(2, "amarillo");
    NumberCard amarillo3 = new NumberCard(3, "amarillo");
    NumberCard amarillo6 = new NumberCard(6, "amarillo");


    SkipCard rojoSkip = new SkipCard("rojo");
    SkipCard azulSkip = new SkipCard("azul");
    SkipCard verdeSkip = new SkipCard("verde");

    DrawTwoCard rojoDrawTwo = new DrawTwoCard("rojo");
    DrawTwoCard azulDrawTwo = new DrawTwoCard("azul");
    DrawTwoCard verdeDrawTwo = new DrawTwoCard("verde");

    ReverseCard azulReverse = new ReverseCard("azul");

    ReverseCard verdeReverse = new ReverseCard("verde");
    WildCard wild = new WildCard();

}
