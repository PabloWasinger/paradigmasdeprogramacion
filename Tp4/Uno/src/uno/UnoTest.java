package uno;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UnoTest {

    @Test
    void testcardtoplaystartsred(){
        assertEquals("red", newGame().cardToPlayColorcard());
    }

    @Test void testcardtoplaystarts1(){
        assertEquals(1, newGame().cardToPlayNumbercard());
    }



    @Test
    void centerPileStartsWithOneCard() {
        assertEquals(1, newGame().centerPile());
    }

    @Test
    void testplayer1StartsTheGame() {

    }

    @Test
    void testplayerStartsWithSevenCards() {
        assertEquals(7, newPlayer().cards());
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
    private Player newPlayer(){return new Player();}
    private UnoGame newGame(){return new UnoGame();}
    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }

}
