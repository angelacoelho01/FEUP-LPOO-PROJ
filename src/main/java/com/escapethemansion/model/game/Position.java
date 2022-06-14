package com.escapethemansion.model.game;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(int x) {
        this(x, 0);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getLeft() {
        return new Position(x -1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position addX(int x) {
        return new Position(getX() + x, getY());
    }

    public Position addY(int y) {
        return new Position(getX(), getY() + y);
    }

    public Position add(Position position) {
        return new Position(getX() + position.getX(), getY() + position.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

