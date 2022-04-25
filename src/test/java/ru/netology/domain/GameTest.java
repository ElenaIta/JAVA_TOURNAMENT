package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();

    private Player first = new Player(1, "first", 100);
    private Player second = new Player(2, "second", 200);
    private Player third = new Player(3, "third", 300);
    private Player fourth = new Player(4, "fourth", 300);
    private Player fifth = new Player(5, "fifth", 100300);
    private Player sixth = new Player(6, "sixth", 3300);

    @BeforeEach
    void setUp() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(fourth);
    }

    @Test
    void shouldWinFirstPlaeyr() {
        int actual = game.round(fourth.getName(), second.getName());

        assertEquals(1, actual);
    }

    @Test
    void shouldWinSecondPlaeyr() {
        int actual = game.round(first.getName(), second.getName());

        assertEquals(2, actual);
    }

    @Test
    void shouldDraw() {
        int actual = game.round(third.getName(), fourth.getName());

        assertEquals(0, actual);
    }

    @Test
    void shouldFindAllRegistered() {
        assertEquals(List.of(first, second, third, fourth), game.findAll());
    }

    @Test
    void shouldFindNameWhenRegister() {
        assertEquals(second, game.findByName("second"));
    }

    @Test
    void returnNullNotRegister() {
        assertNull(game.findByName("fifth"));
    }

    @Test
    void shouldThrowExceptionWhenPlayerNORegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round(third.getName(), fifth.getName()));
    }

    @Test
    void shouldThrowExceptionWhenPlayersBothUnregistered() {

        assertThrows(NotRegisteredException.class, () -> game.round(fifth.getName(), sixth.getName()));
//        System.out.println(Arrays.toString());
    }
}