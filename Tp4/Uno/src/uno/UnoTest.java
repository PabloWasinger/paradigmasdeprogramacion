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
        assertEquals("red", newGame1().getJugada());
    }

    @Test void testcardtoplaystarts1(){
        assertEquals(1, newGame1().getJugada());
    }



    @Test
    void centerPileStartsWithOneCard() {
        assertEquals(1, newGame1());
    }



    @Test
    void testplayer1StartsTheGame() {

    }

    @Test
    void testplayerStartsWithSevenCards() {
        assertEquals(7, newGame().cards());
    }


    @Test void playerDiscardCardsCorrectlyIfItIsMatchingColor(){

    }

    @Test void playerDiscardCardsCorrectlyIfItIsMatchingNumber(){

    }

    @Test void cannotPlaynonMatchingCard(){
        assertThrowsLike("Cannot play non-matching card", () -> newPlayer().discard());
    }

    @Test void testoneLessCardAfterPlaying(){
        assertEquals(6, newPlayer().discard().cards());

    }

    @Test void testplayer2sTurnAfterPlayer1(){
        assertEquals(2, newPlayer().turn());
    }

    @Test void test7playerDrawsCardIfNoMatchingCard(){
        assertEquals(8, newPlayer().drawCard().cards());
    }

    @Test void testplayerCannotPlayMoreCardsThanTheyHave(){

    }

    @Test void gameEndsWhenPlayerHasNoCards(){
        assertEquals("Game Over", newGame().gameOver());
    }


    @Test void test11playerCannotPlayWhenNotTheirTurn() {
        // Implement your test logic here
    }

    @Test void test12playerCanPlayWildCardAnytime() {
        // Implement your test logic here
    }

    @Test void test13playerCanPlaySkipCardToSkipNextPlayerTurn() {
        // Implement your test logic here
    }

    @Test void test14playerCanPlayReverseCardToReverseTurnOrder() {
        // Implement your test logic here
    }

    @Test void test15playerCanPlayDrawTwoCardToMakeNextPlayerDrawTwoCards() {
        // Implement your test logic here
    }

    //test6playerCanOnlyPlayMatchingCard: This test will ensure that a player can only play a card that matches the color or number of the card on top of the discard pile.
            //test7playerDrawsCardIfNoMatchingCard: This test will ensure that if a player doesn't have a matching card, they must draw a card from the deck.
    //test8gameEndsWhenPlayerHasNoCards: This test will ensure that the game ends when a player has no more cards.
            //test9playerMustShoutUnoWhenOneCardLeft: This test will ensure that a player must shout "Uno" when they only have one card left.
            //test10playerDrawsTwoCardsIfFailToShoutUno: This test will ensure that if a player fails to shout "Uno" when they only have one card left, they must draw two cards.

    private UnoGame newGame(HashMap<Integer, ArrayList<Card>> pila){
        return new UnoGame(pila);}
    private Card newNumberedCard(String color, int number){return new Card(color, number);}
    private Card newSpecialCard(String color, String type){return new Card(color, type);}




    private UnoGame newGame1(){
        HashMap<Integer, ArrayList<Card>> pila = new HashMap<Integer, ArrayList<Card>>();
        pila.put(-1 , new ArrayList<Card>(Arrays.asList(newNumberedCard("red", 1))));
        pila.put(1, new ArrayList<Card>(Arrays.asList(newNumberedCard("red", 2))));
        pila.put(2, new ArrayList<Card>(Arrays.asList(newNumberedCard("red", 3))));

        return newGame(pila);
    }

    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }

}
