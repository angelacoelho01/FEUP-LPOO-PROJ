package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoxTest {

    private Box b;

    @BeforeEach
    public void setup(){
        b = new Box( new Position(3, 4));
        b.setAppearance("B");
        b.setColor("#FFFF00");
    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), b.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("B", b.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#FFFF00", b.getColor());
    }

    @Test
    void setPosition() {
        b.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), b.getPosition());
    }

    @Test
    void setAppearance() {
        b.setAppearance("b");
        assertEquals("b", b.getAppearance());
    }

    @Test
    void setColor() {
        b.setColor("#FEDCBA");
        assertEquals("#FEDCBA", b.getColor());
    }
}
