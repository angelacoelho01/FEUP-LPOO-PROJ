package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlashLightTest {

    private FlashLight flashLight;

    @BeforeEach
    void setup() {
        this.flashLight = new FlashLight(50);
        this.flashLight.setColor("#FFFFFF");
    }

    @Test
    public void getValue(){
        assertEquals(this.flashLight.getValue(), 50);
    }

    @Test
    public void setValue(){
        this.flashLight.setValue(63);
        assertEquals(this.flashLight.getValue(), 63);
    }

    @Test
    public void getColor(){
        assertEquals(this.flashLight.getColor(), "#FFFFFF");
    }

    @Test
    public void setColor(){
        this.flashLight.setColor("#FF00FF");
        assertEquals(this.flashLight.getColor(), "#FF00FF");
    }

    @Test
    public void getAppearance(){
        assertEquals(this.flashLight.getAppearance(), "S");
    }

    @Test
    public void getInterval(){
        assertEquals(this.flashLight.getInterval(), new Position(8));
    }

    @Test
    public void getText(){
        assertEquals(this.flashLight.getText(), "battery");
    }

    @Test
    public void getPosition(){
        assertEquals(this.flashLight.getPosition(), new Position(1, 12));
    }

    @Test
    public void setPosition(){
        this.flashLight.setPosition(new Position(2, 12));
        assertEquals(this.flashLight.getPosition(), new Position(2, 12));
    }

    @Test
    public void decreaseValue(){
        this.flashLight.decreaseValue();
        assertEquals(this.flashLight.getValue(), 40);
    }

    @Test
    public void increaseValue(){
        this.flashLight.increaseValue();
        assertEquals(this.flashLight.getValue(), 60);
    }
}
