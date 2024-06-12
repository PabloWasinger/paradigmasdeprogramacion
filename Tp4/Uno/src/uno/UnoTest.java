package uno;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UnoTest {

    @Test
    void testCenterCardStartsRed(){
        assertEquals("red", newGame1().getColor());
    }

    @Test void testcardtoplaystarts1(){
        assertEquals("1", newGame1().getNumber());
    }


    @Test void playerDiscardCardsCorrectlyIfItIsMatchingColor(){
        assertEquals("red", newGame1().playCard("red", "2", "numbered").getColor());
    }

    @Test void playerDiscardCardsCorrectlyIfItIsMatchingNumber(){
        assertEquals("blue", newGame1().playCard("blue", "1", "numbered").getColor());

    }

    @Test void cannotPlaynonMatchingCard(){
        assertThrowsLike("Cannot play non-matching card", () -> newGame1().playCard("yellow", "6", "numbered"));
    }

    @Test void testplayer2sTurnAfterPlayer1(){
        assertEquals(1, newGame1().playCard("red", "2", "numbered").turn());
    }
    @Test void player2CanPlayAfterPlayer1(){
        assertEquals("red", newGame1().playCard("red", "2", "numbered").playCard("red", "3", "numbered").getColor());
    }

    @Test void test7player2TurnIfPlayer1TakeCard(){
        assertEquals(1, newGame1().takeCard().turn());
    }



    @Test void gameEndsWhenPlayerHasNoCards(){
        assertThrowsLike("Game Over", () -> newGame3().playCard("red", "2", "numbered"));
    }


    @Test void test9CanDrawCard(){
        assertEquals("red", newGame0().takeCard().getColor());
    }

    @Test void testIsNextPlayerTurnAfterDrawingCard(){
        assertEquals("2", newGame11().takeCard().playCard("red", "2", "numbered").getNumber());
    }

    @Test void testcCanPlayDrawedUpCard(){
        assertEquals("blue", newGame11().takeCard().playCard("red", "2", "numbered").playCard("blue", "2", "numbered").getColor());
    }




    @Test void test10Player1TurnSkip(){
      assertEquals(null, newGame4().playCard("blue", null, "skip").
              playCard("blue", "6", "numbered"));
    }

    @Test void test12playerCanPlayWildCardAnytime() {
        assertEquals("yellow", newGame5().playCard("yellow", null, "wild").getColor());
    }

//    @Test void test13playerCanPlaySkipCardToSkipNextPlayerTurn() {
//        // Implement your test logic here
//    }

//    @Test void test14playerCanPlayReverseCardToReverseTurnOrder() {
//        // Implement your test logic here
//    }
//
//    @Test void test15playerCanPlayDrawTwoCardToMakeNextPlayerDrawTwoCards() {
//        // Implement your test logic here
//    }

    //test6playerCanOnlyPlayMatchingCard: This test will ensure that a player can only play a card that matches the color or number of the card on top of the discard pile.
            //test7playerDrawsCardIfNoMatchingCard: This test will ensure that if a player doesn't have a matching card, they must draw a card from the deck.
    //test8gameEndsWhenPlayerHasNoCards: This test will ensure that the game ends when a player has no more cards.
            //test9playerMustShoutUnoWhenOneCardLeft: This test will ensure that a player must shout "Uno" when they only have one card left.
            //test10playerDrawsTwoCardsIfFailToShoutUno: This test will ensure that if a player fails to shout "Uno" when they only have one card left, they must draw two cards.

    private UnoGame newGame(ArrayList<ArrayList<Card1>> pile){
        return new UnoGame(pile);}

    private ArrayList<String> newCard(String color, String number, String type){
        return new ArrayList<>(Arrays.asList(color, number, type));

    }

    // Crear las cartas
    NumberCard rojo1 = new NumberCard(1, "rojo");
    NumberCard rojo2 = new NumberCard(2, "rojo");
    NumberCard rojo3 = new NumberCard(3, "rojo");

    NumberCard azul1 = new NumberCard(1, "azul");
    NumberCard azul2 = new NumberCard(2, "azul");
    NumberCard azul3 = new NumberCard(3, "azul");

    // Crear las cartas
    NumberCard verde1 = new NumberCard(1, "verde");
    NumberCard verde2 = new NumberCard(2, "verde");
    NumberCard verde3 = new NumberCard(3, "verde");

    NumberCard amarillo1 = new NumberCard(1, "amarillo");
    NumberCard amarillo2 = new NumberCard(2, "amarillo");
    NumberCard amarillo3 = new NumberCard(3, "amarillo");
    // Crear las cartas
    SkipCard rojoSkip = new SkipCard("rojo");
    SkipCard azulSkip = new SkipCard("azul");
    SkipCard verdeSkip = new SkipCard("verde");
    SkipCard amarilloSkip = new SkipCard("amarillo");

    DrawTwoCard rojoDrawTwo = new DrawTwoCard("rojo");
    DrawTwoCard azulDrawTwo = new DrawTwoCard("azul");
    DrawTwoCard verdeDrawTwo = new DrawTwoCard("verde");
    DrawTwoCard amarilloDrawTwo = new DrawTwoCard("amarillo");
    ReverseCard rojoReverse = new ReverseCard("rojo");
    ReverseCard azulReverse = new ReverseCard("azul");
    ReverseCard amarilloReverse = new ReverseCard("amarillo");
    ReverseCard verdeReverse = new ReverseCard("verde");
    WildCard wild = new WildCard();


    private UnoGame newGame0(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<Card1>>(Arrays.asList(
                azul2,
                amarillo2,
                rojo2,
                rojo1

        ));
        return newGame(pile);
    }

    private UnoGame newGame11() {
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<String>>(Arrays.asList(
                newCard("blue", "2", "numbered"),
                newCard("yellow", "2", "numbered"),
                rojo2,
                rojo1,
                newCard("yellow", "6", "numbered"),
                newCard("blue", "3", "numbered")

        ));
        return newGame(pile);
    }

    private UnoGame newGame1(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<Card1>>(Arrays.asList(
                newCard("blue", "2", "numbered"),
                rojo2,
                rojo3,
                rojo1,
                newCard("blue", "1", "numbered"),
                newCard("blue", "3", "numbered"),
                newCard("blue", "4", "numbered")

        ));
        return newGame(pile);
    }
    private UnoGame newGame2(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<Card1>>(Arrays.asList(
                newCard("blue", "2", "numbered"),
                newCard("yellow", "6", "numbered"),
                rojo3

        ));
        return newGame(pile);
    }

    private UnoGame newGame3(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<Card1>>(Arrays.asList(
                rojo1,
                rojo2,
                rojo3
        ));
        return newGame(pile);
    }
    private UnoGame newGame4(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<String>>(Arrays.asList(
                newCard("blue", "2", "numbered"),
                newCard("blue", null, "skip"),
                newCard("red", "5", "numbered"),
                rojo2,
                newCard("blue", "6", "numbered")

        ));
        return newGame(pile);
    }

    private UnoGame newGame5(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<Card1>>(Arrays.asList(
                rojo1,
                wild,
                rojo3,
                rojo4,
                rojo3,
                amarillo3
        ));
        return newGame(pile);
    }

    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }

}
