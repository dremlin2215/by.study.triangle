package comparator;

import entity.Triangle;

import java.util.Comparator;

public class TriangleNameComparator implements Comparator<Triangle> {
    public int compare(Triangle o1, Triangle o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
