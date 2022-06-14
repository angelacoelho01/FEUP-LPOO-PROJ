package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerComponentTest {

    private PlayerComponent playerComponent;

    @BeforeEach
    void setup() {
        this.playerComponent = new PlayerComponent(50);
        this.playerComponent.setColor("#FFFFFF");
    }

    @Test
    public void getValue(){
        assertEquals(this.playerComponent.getValue(), 50);
    }

    @Test
    public void setValue(){
        this.playerComponent.setValue(63);
        assertEquals(this.playerComponent.getValue(), 63);
    }

    @Test
    public void getColor(){
        assertEquals(this.playerComponent.getColor(), "#FFFFFF");
    }

    @Test
    public void setColor(){
        this.playerComponent.setColor("#FF00FF");
        assertEquals(this.playerComponent.getColor(), "#FF00FF");
    }

    @Test
    public void getAppearance(){
        assertEquals(this.playerComponent.getAppearance(), "S");
    }

    @Test
    public void getInterval(){
        assertEquals(this.playerComponent.getInterval(), new Position(8));
    }

    @Test
    public void decreaseValue(){
        this.playerComponent.decreaseValue();
        assertEquals(this.playerComponent.getValue(), 49);
    }

    @Test
    public void increaseValue(){
        this.playerComponent.increaseValue();
        assertEquals(this.playerComponent.getValue(), 51);
    }
}
