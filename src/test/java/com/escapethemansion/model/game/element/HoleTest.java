package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoleTest {

    private Hole h;

    @BeforeEach
    public void setup(){
        h = new Hole( new Position(3, 4));
        h.setAppearance("H");
        h.setColor("#FFFF00");
    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), h.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("H", h.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#FFFF00", h.getColor());
    }

    @Test
    void setPosition() {
        h.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), h.getPosition());
    }

    @Test
    void setAppearance() {
        h.setAppearance("h");
        assertEquals("h", h.getAppearance());
    }

    @Test
    void setColor() {
        h.setColor("#FEDCBA");
        assertEquals("#FEDCBA", h.getColor());
    }
}
