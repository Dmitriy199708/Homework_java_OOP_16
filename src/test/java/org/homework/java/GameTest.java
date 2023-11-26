package org.homework.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.TextParsingException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testRound_Player1Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 5);
        game.register(player1);
        game.register(player2);

        int result = game.round("Player1", "Player2");

        assertEquals(1, result);
    }

    @Test
    public void testRound_Player2Wins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 5);
        Player player2 = new Player(2, "Player2", 10);
        game.register(player1);
        game.register(player2);

        int result = game.round("Player1", "Player2");

        assertEquals(2, result);
    }

    @Test
    public void testRound_Draw() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 5);
        Player player2 = new Player(2, "Player2", 5);
        game.register(player1);
        game.register(player2);

        int result = game.round("Player1", "Player2");

        Assertions.assertEquals(0, result);
    }

    @Test
    public void testRound_PlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 5);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Player1", "Player2");
        });

    }

}