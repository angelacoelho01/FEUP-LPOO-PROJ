package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeTest {

    private Life life;

    @BeforeEach
    void setup() {
        this.life = new Life(50);
        this.life.setColor("#FFFFFF");
    }

    @Test
    public void getValue(){
        assertEquals(this.life.getValue(), 50);
    }

    @Test
    public void setValue(){
        this.life.setValue(63);
        assertEquals(this.life.getValue(), 63);
    }

    @Test
    public void getColor(){
        assertEquals(this.life.getColor(), "#FFFFFF");
    }

    @Test
    public void setColor(){
        this.life.setColor("#FF00FF");
        assertEquals(this.life.getColor(), "#FF00FF");
    }

    @Test
    public void getAppearance(){
        assertEquals(this.life.getAppearance(), "S");
    }

    @Test
    public void getInterval(){
        assertEquals(this.life.getInterval(), new Position(8));
    }

    @Test
    public void getText(){
        assertEquals(this.life.getText(), "life");
    }

    @Test
    public void getPosition(){
        assertEquals(this.life.getPosition(), new Position(1, 8));
    }

    @Test
    public void setPosition(){
        this.life.setPosition(new Position(2, 12));
        assertEquals(this.life.getPosition(), new Position(2, 12));
    }

    @Test
    public void decreaseValue(){
        this.life.decreaseValue();
        assertEquals(this.life.getValue(), 40);
    }

    @Test
    public void increaseValue(){
        this.life.increaseValue();
        assertEquals(this.life.getValue(), 51);
    }
}
