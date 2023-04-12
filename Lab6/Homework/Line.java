package com.mycompany.lab6homework;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Roxana Dobrica
 */
public class Line implements Serializable {

    private Dot dot1, dot2;

    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
    }

    public Line() {
    }

    public boolean isConnected(Line line) {
        if (this.getDot1().getX() == line.getDot1().getX() && this.getDot1().getY() == line.getDot1().getY()) {
            return true;
        }
        if (this.getDot1().getX() == line.getDot2().getX() && this.getDot1().getY() == line.getDot2().getY()) {
            return true;
        }
        if (this.getDot2().getX() == line.getDot1().getX() && this.getDot2().getY() == line.getDot1().getY()) {
            return true;
        }
        if (this.getDot2().getX() == line.getDot2().getX() && this.getDot2().getY() == line.getDot2().getY()) {
            return true;
        }
        return false;
    }

    public Dot getDot1() {
        return dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    @Override
    public String toString() {
        return "Line{" + "dot1=" + dot1 + ", dot2=" + dot2 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.dot1);
        hash = 97 * hash + Objects.hashCode(this.dot2);
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
        final Line other = (Line) obj;
        if (!Objects.equals(this.dot1, other.dot1)) {
            return false;
        }
        return Objects.equals(this.dot2, other.dot2);
    }

}
