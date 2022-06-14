package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GhostTest {

    private Ghost g;

    @BeforeEach
    public void setup(){
        g = new Ghost( new Position(3, 4));
        g.setAppearance("G");
        g.setColor("#FFFFFF");
    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), g.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("G", g.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#FFFFFF", g.getColor());
    }

    @Test
    void setPosition() {
        g.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), g.getPosition());
    }

    @Test
    void setAppearance() {
        g.setAppearance("g");
        assertEquals("g", g.getAppearance());
    }

    @Test
    void setColor() {
        g.setColor("#FEDCBA");
        assertEquals("#FEDCBA", g.getColor());
    }
}