package comparator;

import entity.Triangle;

import java.util.Comparator;

public class TriangleIdComparator implements Comparator<Triangle> {

    public int compare(Triangle o1, Triangle o2) {
        return o1.getId() - o2.getId();
    }
}
