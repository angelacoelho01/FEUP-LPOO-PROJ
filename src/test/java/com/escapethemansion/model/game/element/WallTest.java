package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    private Wall w;

    @BeforeEach
    public void setup(){
        w = new Wall( new Position(3, 4));
        w.setAppearance("#");
        w.setColor("#8C2D19");

    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), w.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("#", w.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#8C2D19", w.getColor());
    }

    @Test
    void setPosition() {
        w.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), w.getPosition());
    }

    @Test
    void setAppearance() {
        w.setAppearance("w");
        assertEquals("w", w.getAppearance());
    }

    @Test
    void setColor() {
        w.setColor("#FEDCBA");
        assertEquals("#FEDCBA", w.getColor());
    }
}
