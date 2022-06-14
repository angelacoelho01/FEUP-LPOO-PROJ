package com.escapethemansion.model.game.floor;

import com.escapethemansion.model.game.Position;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorBuilderTest {

    private FloorBuilder floorBuilder;

    @BeforeEach
    void setup() throws IOException {
        floorBuilder = new FloorBuilder("./src/test/resources/floors/floor.map");
    }

    @Test
    void getOffset() {
        assertEquals(new Position(12, 8), floorBuilder.getOffset());
    }

    @Test
    void getWidth() {
        assertEquals(15, floorBuilder.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(15, floorBuilder.getHeight());
    }
}