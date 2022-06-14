package com.escapethemansion.controller;

import com.escapethemansion.controller.game.GhostController;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.Box;
import com.escapethemansion.model.game.element.Ghost;
import com.escapethemansion.model.game.element.GhostTest;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GhostControllerTest {

    private GhostController ghostController;

    @BeforeEach
    void setup() throws IOException {
        Floor floor = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        this.ghostController = new GhostController(floor);
    }

    @Test
    void getFloor() throws IOException {
        Floor test = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        assertEquals(this.ghostController.getModel(), test);
    }

    @Test
    void getGhost(){
        assertEquals(this.ghostController.getModel().getGhosts().get(0), new Ghost(new Position(24,9)));
    }

    @Test
    void setGhost(){
        this.ghostController.getModel().getGhosts().get(0).setPosition(new Position(20,13));
        assertEquals(this.ghostController.getModel().getGhosts().get(0), new Ghost(new Position(20,13)));
    }

    @Test
    void canGhostMove() {
        assertFalse(this.ghostController.canElementMove(new Position(24,9)));
        assertTrue(this.ghostController.canElementMove(new Position(11,1)));
    }
}
