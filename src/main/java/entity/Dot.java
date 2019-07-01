package entity;


public class Dot {
    private double x;
    private double y;

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return x == dot.x && y == dot.y;
    }

    @Override
    public int hashCode() {
        int result = 23;
        long longBits = Double.doubleToLongBits(x);
        result = 37 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(y);
        result = 37 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return ("x = " + x + ", y = " + y);
    }
}
