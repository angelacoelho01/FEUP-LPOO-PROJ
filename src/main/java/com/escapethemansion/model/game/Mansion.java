package com.escapethemansion.model.game;

import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mansion {

    private List<Floor> floors;

    public Mansion() throws IOException {
        this.floors = new ArrayList<>();
        this.floors.add(new FloorBuilder("src/main/resources/floors/basement.map").createFloor());
        this.floors.add(new FloorBuilder("src/main/resources/floors/1stfloor.map").createFloor());
        this.floors.add(new FloorBuilder("src/main/resources/floors/2ndfloor.map").createFloor());
        this.floors.add(new FloorBuilder("src/main/resources/floors/attic.map").createFloor());
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void resetFloors() throws IOException {
        List<Floor> floors = new ArrayList<>();
        floors.add(new FloorBuilder("src/main/resources/floors/basement.map").createFloor());
        floors.add(new FloorBuilder("src/main/resources/floors/1stfloor.map").createFloor());
        floors.add(new FloorBuilder("src/main/resources/floors/2ndfloor.map").createFloor());
        floors.add(new FloorBuilder("src/main/resources/floors/attic.map").createFloor());
        this.floors = floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mansion mansion = (Mansion) o;
        return Objects.equals(floors, mansion.floors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floors);
    }
}
