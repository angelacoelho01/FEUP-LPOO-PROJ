package com.escapethemansion.model.game.floor;

import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.*;
import com.escapethemansion.model.game.timer.FloorTimer;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class Floor {
    private Player player;
    private List<Wall> walls;
    private List<Ghost> ghosts;
    private List<Door> doors;
    private List<Key> keys;
    private List<Box> boxes;
    private List<Hole> holes;
    private List<Battery> batteries;
    private String title;
    private final FloorTimer timer;
    private EndLevel levelEnd;
    private Weapon weapon;
    private int currPoints;

    private Position offset;
    private final int width;
    private final int height;
    private final int numGhosts;

    public Floor(int width, int height, int numGhosts) {
        this.width = width;
        this.height = height;
        this.offset = new Position(0,0);
        this.timer = new FloorTimer(5, 0, this);
        this.numGhosts = numGhosts;
        this.currPoints = 0;
        timer.startTimer();
    }

    public Position getOffset() {
        return offset;
    }

    public void setOffset(Position offset) {
        this.offset = offset;
    }

    public FloorTimer getTimer() {
        return timer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public EndLevel getLevelEnd() {
        return levelEnd;
    }

    public void setLevelEnd(EndLevel levelEnd) {
        this.levelEnd = levelEnd;
    }
    
    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public List<Hole> getHoles() {
        return this.holes;
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalNumKeys() {
        return player.getNumKeys() + keys.size();
    }

    public List<Battery> getBatteries() {
        return batteries;
    }

    public void setBatteries(List<Battery> batteries) {
        this.batteries = batteries;
    }

    public void removeBattery(Battery battery) {
        this.batteries.remove(battery);
    }
    public int getTotalNumGhosts() { return this.numGhosts;}

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void removeWeapon() {
        this.weapon = null;
    }

    public boolean collectPlayerKey(Key keyToCollect) {
        for(int i = 0; i < keys.size(); i++) {
            if(keys.get(i).equals(keyToCollect)) {
                keys.remove(i);
                player.addKey();
                addPoints(100);
                System.out.println("Key collected!");

                if(!doors.isEmpty())
                    doors.remove(doors.size()-1);
                else
                    System.out.println("End of Level Doors!");

                return true;
            }
        }
        return  false;
    }

    public void addPoints(int pointsToAdd) {this.currPoints += pointsToAdd;}
    public int getCurrPoints(){return this.currPoints;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return width == floor.width && height == floor.height && Objects.equals(player, floor.player) && Objects.equals(walls, floor.walls) && Objects.equals(ghosts, floor.ghosts) && Objects.equals(keys, floor.keys) && Objects.equals(doors, floor.doors) && Objects.equals(title, floor.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, walls, ghosts, keys, doors, title, width, height);
    }

}
