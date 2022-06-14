package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    private Element e;

    @BeforeEach
    public void setup(){
        e = new Element( new Position(3, 4));
        e.setAppearance("E");
        e.setColor("#ABCDEF");
    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), e.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("E", e.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#ABCDEF", e.getColor());
    }

    @Test
    void setPosition() {
        e.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), e.getPosition());
    }

    @Test
    void setAppearance() {
        e.setAppearance("e");
        assertEquals("e", e.getAppearance());
    }

    @Test
    void setColor() {
        e.setColor("#FEDCBA");
        assertEquals("#FEDCBA", e.getColor());
    }
}
