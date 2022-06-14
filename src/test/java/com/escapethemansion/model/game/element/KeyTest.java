package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyTest {

    private Key k;

    @BeforeEach
    public void setup(){
        k = new Key( new Position(3, 4));
        k.setAppearance("K");
        k.setColor("#FFFF00");
    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), k.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("K", k.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#FFFF00", k.getColor());
    }

    @Test
    void setPosition() {
        k.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), k.getPosition());
    }

    @Test
    void setAppearance() {
        k.setAppearance("k");
        assertEquals("k", k.getAppearance());
    }

    @Test
    void setColor() {
        k.setColor("#FEDCBA");
        assertEquals("#FEDCBA", k.getColor());
    }
}