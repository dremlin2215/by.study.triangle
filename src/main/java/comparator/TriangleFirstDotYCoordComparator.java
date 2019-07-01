package comparator;

import entity.Triangle;

import java.util.Comparator;

public class TriangleFirstDotYCoordComparator implements Comparator<Triangle> {

    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getA().getY() - o2.getA().getY());
    }
}
