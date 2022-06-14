package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;

import java.util.Objects;

import static java.lang.String.valueOf;

public class PlayerComponent {
    protected int value;
    protected String color;
    protected String text;
    protected Position position;
    private final Position interval;
    private final String appearence;

    public PlayerComponent(int value) {
        this.value = value;
        this.appearence = "S";
        this.interval = new Position(8);
    }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public String getAppearance() {
        return appearence;
    }

    public Position getInterval() {
        return interval;
    }

    public String getText() {
        return text;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void decreaseValue() {
        this.value--;
    }

    public void increaseValue() {
        this.value++;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getValueStr() {
        return valueOf(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerComponent that = (PlayerComponent) o;
        return value == that.value && Objects.equals(color, that.color) && Objects.equals(text, that.text) && Objects.equals(position, that.position) && Objects.equals(interval, that.interval) && Objects.equals(appearence, that.appearence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color, text, position, interval, appearence);
    }
}
