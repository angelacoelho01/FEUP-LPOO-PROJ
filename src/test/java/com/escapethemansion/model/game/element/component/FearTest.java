package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FearTest {

    private Fear fear;

    @BeforeEach
    void setup() {
        this.fear = new Fear(50);
        this.fear.setColor("#FFFFFF");
    }

    @Test
    public void getValue(){
        assertEquals(this.fear.getValue(), 50);
    }

    @Test
    public void setValue(){
        this.fear.setValue(63);
        assertEquals(this.fear.getValue(), 63);
    }

    @Test
    public void getColor(){
        assertEquals(this.fear.getColor(), "#FFFFFF");
    }

    @Test
    public void setColor(){
        this.fear.setColor("#FF00FF");
        assertEquals(this.fear.getColor(), "#FF00FF");
    }

    @Test
    public void getAppearance(){
        assertEquals(this.fear.getAppearance(), "S");
    }

    @Test
    public void getInterval(){
        assertEquals(this.fear.getInterval(), new Position(8));
    }

    @Test
    public void getText(){
        assertEquals(this.fear.getText(), "fear");
    }

    @Test
    public void getPosition(){
        assertEquals(this.fear.getPosition(), new Position(1, 10));
    }

    @Test
    public void setPosition(){
        this.fear.setPosition(new Position(2, 12));
        assertEquals(this.fear.getPosition(), new Position(2, 12));
    }

    @Test
    public void decreaseValue(){
        this.fear.decreaseValue();
        assertEquals(this.fear.getValue(), 40);
    }

    @Test
    public void increaseValue(){
        this.fear.increaseValue();
        assertEquals(this.fear.getValue(), 55);
    }
}
