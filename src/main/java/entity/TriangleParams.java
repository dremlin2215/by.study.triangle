package entity;

import action.TriangleAction;
import observer.iTriangleObserver;

import java.util.Objects;

public class TriangleParams implements iTriangleObserver {

    private double square;
    private double perimeter;

    public TriangleParams(Triangle triangle) {
        square = TriangleAction.getInstance().getSquare(triangle);
        perimeter = TriangleAction.getInstance().getPerimeter(triangle);
    }

    public double getSquare() {
        return square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleParams that = (TriangleParams) o;
        return Double.compare(that.square, square) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(square, perimeter);
    }

    @Override
    public String toString() {
        return "TriangleParams{" +
                "square=" + square +
                ", perimeter=" + perimeter +
                '}';
    }

    public void update(Triangle triangle) {
        this.perimeter = TriangleAction.getInstance().getPerimeter(triangle);
        this.square = TriangleAction.getInstance().getSquare(triangle);
    }
}
