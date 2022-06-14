package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player p;

    @BeforeEach
    public void setup(){
        p = new Player( new Position(3, 4));
        p.setAppearance("X");
        p.setColor("#FFDE82");
    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), p.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("X", p.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#FFDE82", p.getColor());
    }

    @Test
    void setPosition() {
        p.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), p.getPosition());
    }

    @Test
    void setAppearance() {
        p.setAppearance("p");
        assertEquals("p", p.getAppearance());
    }

    @Test
    void setColor() {
        p.setColor("#FEDCBA");
        assertEquals("#FEDCBA", p.getColor());
    }
}
