package com.escapethemansion.model;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PositionTest {

    private Position pos;

    @BeforeEach
    void setup(){
       pos = new Position(4, 5);
    }

    @Test
    void getLeft() {
        assertEquals(new Position(3, 5), pos.getLeft());
    }

    @Test
    void getRight() {
        assertEquals(new Position(5, 5), pos.getRight());
    }

    @Test
    void getUp() {
        assertEquals(new Position(4, 4), pos.getUp());
    }

    @Test
    void getDown() {
        assertEquals(new Position(4, 6), pos.getDown());
    }

    @Test
    void getX() {
        assertEquals(4, pos.getX());
    }

    @Test
    void getY() {
        assertEquals(5, pos.getY());
    }
}
