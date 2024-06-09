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
        assertThrowsLike("Game Over", ()-> newGame3().playCard("red", "1", "numbered"));
    }
//
//
//    @Test void test11playerCannotPlayWhenNotTheirTurn() {
//        // Implement your test logic here
//    }
//
//    @Test void test12playerCanPlayWildCardAnytime() {
//        // Implement your test logic here
//    }
//
//    @Test void test13playerCanPlaySkipCardToSkipNextPlayerTurn() {
//        // Implement your test logic here
//    }
//
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

    private UnoGame newGame(ArrayList<ArrayList<String>> pile){
        return new UnoGame(pile);}

    private ArrayList<String> newCard(String color, String number, String type){
        return new ArrayList<>(Arrays.asList(color, number, type));

    }


    private UnoGame newGame1(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<String>>(Arrays.asList(
                newCard("blue", "2", "numbered"),
                newCard("red", "2", "numbered"),
                newCard("red", "3", "numbered"),
                newCard("red", "1", "numbered"),
                newCard("blue", "1", "numbered"),
                newCard("blue", "3", "numbered"),
                newCard("blue", "4", "numbered")

        ));
        return newGame(pile);
    }
    private UnoGame newGame2(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<String>>(Arrays.asList(
                newCard("blue", "2", "numbered"),
                newCard("yellow", "6", "numbered"),
                newCard("red", "3", "numbered")

        ));
        return newGame(pile);
    }

    private UnoGame newGame3(){
        ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<String>>(Arrays.asList(
                newCard("red", "1", "numbered"),
                newCard("red", "2", "numbered"),
                newCard("red", "3", "numbered")
        ));
        return newGame(pile);
    }

    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }

}
