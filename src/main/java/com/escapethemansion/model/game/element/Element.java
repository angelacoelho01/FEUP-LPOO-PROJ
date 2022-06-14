package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

import java.util.Objects;

public class Element {
    private Position position;
    protected String appearance;
    protected String color;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getAppearance() {
        return this.appearance;
    }

    public String getColor() {
        return color;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(position, element.position) && Objects.equals(appearance, element.appearance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, appearance);
    }
}
