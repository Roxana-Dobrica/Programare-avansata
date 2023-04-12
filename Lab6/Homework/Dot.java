package com.mycompany.lab6homework;

import java.io.Serializable;

/**
 *
 * @author Roxana Dobrica
 */
public class Dot implements Serializable {

    private int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Dot() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Dot{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.x;
        hash = 59 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dot other = (Dot) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

}
