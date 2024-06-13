package uno;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import java.util.Arrays;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UnoTest {

    @Test
    void testCenterCardStartsBlue(){
        assertEquals("azul", newGame1().getColor());
    }

    @Test void testcardtoplaystarts1(){
        assertEquals(4, newGame1().getNumber());
    }


    @Test void playerDiscardCardsCorrectlyIfItIsMatchingColor(){
        assertEquals("azul", newGame1().playCard(azul1).getColor());
    }

    @Test void playerDiscardCardsCorrectlyIfItIsMatchingNumber(){
        assertEquals("rojo", newGame1().playCard(rojo2).getColor());

    }

    @Test void cannotPlaynonMatchingCard(){
        assertThrowsLike("Cannot play non-matching card", () -> newGame1().playCard(amarillo6));
    }

    @Test void testplayer2sTurnAfterPlayer1(){
        assertEquals(1, newGame1().playCard(rojo2).turn());
    }
    @Test void player2CanPlayAfterPlayer1(){
        assertEquals("rojo", newGame1().playCard(rojo2).playCard(rojo3).getColor());
    }

    @Test void test7player2TurnIfPlayer1TakeCard(){
        assertEquals(1, newGame1().takeCard().turn());
    }



    @Test void gameEndsWhenPlayerHasNoCards(){
        assertThrowsLike("Game Over", () -> newGame3().playCard(rojo2));
    }


    @Test void test9CanDrawCard(){
        assertEquals("rojo", newGame0().takeCard().getColor());
    }

    @Test void testIsNextPlayerTurnAfterDrawingCard(){
        assertEquals(2, newGame11().takeCard().playCard(rojo2).getNumber());
    }

    @Test void testcCanPlayDrawedUpCard(){
        assertEquals("azul", newGame11().takeCard().playCard(rojo2).playCard(azul2).getColor());
    }



    @Test void test10Player1TurnSkip(){
      assertEquals("azul", newGame4().playCard(azulSkip).
              playCard(azul6).getColor());
    }

    @Test void test12playerCanPlayWildCardAnytime() {
        assertEquals("yellow", newGame5().playCard(wild.beYellow()).getColor());
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

    private UnoGame newGame(ArrayList<ArrayList<Card>> pile){
        return new UnoGame(pile);}

    private ArrayList<String> newCard(String color, String number, String type){
        return new ArrayList<>(Arrays.asList(color, number, type));

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

    NumberCard verde1 = new NumberCard(1, "verde");
    NumberCard verde2 = new NumberCard(2, "verde");
    NumberCard verde3 = new NumberCard(3, "verde");

    NumberCard amarillo1 = new NumberCard(1, "amarillo");
    NumberCard amarillo2 = new NumberCard(2, "amarillo");
    NumberCard amarillo3 = new NumberCard(3, "amarillo");
    NumberCard amarillo6 = new NumberCard(6, "amarillo");


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



    private UnoGame newGame0() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(azul2, rojo1)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo2)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2)));
        return newGame(pile);
    }


    private UnoGame newGame11() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(azul2, rojo1)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo2, amarillo6)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2,azul3)));
        return newGame(pile);
    }
    private UnoGame newGame1() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(azul4, rojo1,azul2)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2,azul1)));
        pile.add(new ArrayList<>(Arrays.asList(rojo3,azul3)));
        return newGame(pile);
    }

    private UnoGame newGame2() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(azul2)));
        pile.add(new ArrayList<>(Arrays.asList(amarillo6)));
        pile.add(new ArrayList<>(Arrays.asList(rojo3)));
        return newGame(pile);
    }


    private UnoGame newGame3() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(rojo1)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2)));
        pile.add(new ArrayList<>(Arrays.asList(rojo3)));
        return newGame(pile);
    }

    private UnoGame newGame4() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(rojo2,azul2 )));
        pile.add(new ArrayList<>(Arrays.asList(azulSkip,azul6)));
        pile.add(new ArrayList<>(Arrays.asList(rojo5,azul1)));
        return newGame(pile);
    }


private UnoGame newGame5() {
        ArrayList<ArrayList<Card>> pile = new ArrayList<>();
        pile.add(new ArrayList<>(Arrays.asList(rojo1, rojo4)));
        pile.add(new ArrayList<>(Arrays.asList(wild, rojo3)));
        pile.add(new ArrayList<>(Arrays.asList(rojo2)));
        return newGame(pile);
    }

    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }

}
