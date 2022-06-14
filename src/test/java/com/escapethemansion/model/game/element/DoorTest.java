package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoorTest {

    private Door d;

    @BeforeEach
    public void setup(){
        d = new Door(new Position(3, 4), true);
        d.setColor("#FFFF00");
    }

    @Test
    void getPosition() {
        assertEquals(new Position(3, 4), d.getPosition());
    }

    @Test
    void getAppearance() {
        assertEquals("|", d.getAppearance());
    }

    @Test
    void getColor() {
        assertEquals("#FFFF00", d.getColor());
    }

    @Test
    void setPosition() {
        d.setPosition(new Position(0, 2));
        assertEquals(new Position(0, 2), d.getPosition());
    }

    @Test
    void setAppearance() {
        d.setAppearance("d");
        assertEquals("d", d.getAppearance());
    }

    @Test
    void setColor() {
        d.setColor("#FEDCBA");
        assertEquals("#FEDCBA", d.getColor());
    }
}
