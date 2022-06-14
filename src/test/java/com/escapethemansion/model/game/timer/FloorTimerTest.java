package com.escapethemansion.model.game.timer;

import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FloorTimerTest {

    private FloorTimer floorTimer;

    @BeforeEach
    void setup() throws IOException {
        this.floorTimer = new FloorTimer(5, 30, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor());
    }

    @Test
    void timeIsUp() throws IOException {
        this.floorTimer = new FloorTimer(0, 0, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor());
        assertTrue(this.floorTimer.timeIsUp());
    }

    @Test
    void pauseTimer() throws IOException {
        this.floorTimer = new FloorTimer(5, 30, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor());
        this.floorTimer.pauseTimer();
        assertTrue(this.floorTimer.isPaused());

        this.floorTimer = new FloorTimer(5, 30, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor());
        this.floorTimer.resumeTimer();
        assertFalse(this.floorTimer.isPaused());
    }

    @Test
    void getTime(){
        assertEquals(this.floorTimer.getTime(), String.format("%02d:%02d", 5, 30));
    }
}
