package com.example.indoormap;

import java.util.Locale;

public class Position {
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Position() {
    }

    private double x;
    private double y;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "x: %f, y: %f", x, y);
    }
}
