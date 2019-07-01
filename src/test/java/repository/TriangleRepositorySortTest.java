package repository;

import comparator.TriangleFirstDotXCoordComparator;
import comparator.TriangleFirstDotYCoordComparator;
import comparator.TriangleIdComparator;
import comparator.TriangleNameComparator;
import entity.Dot;
import entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriangleRepositorySortTest {

    public TriangleRepository triangleRepository = TriangleRepository.getInstance();
    public Comparator triangleIdComparator = new TriangleIdComparator();
    public Comparator triangleNameComparator = new TriangleNameComparator();
    public Comparator triangleFirstDotXCoord = new TriangleFirstDotXCoordComparator();
    public Comparator triangleFirstDotYCoord = new TriangleFirstDotYCoordComparator();
    Triangle triangle1;
    Triangle triangle2;
    Triangle triangle3;

    @BeforeClass
    public void setUp() {
        triangle1 = new Triangle(new Dot(0, 0), new Dot(0, 4), new Dot(5, 0), "name1");
        triangle2 = new Triangle(new Dot(-1, -1), new Dot(-1, -5), new Dot(-6, -1), "name3");
        triangle3 = new Triangle(new Dot(0, 0), new Dot(0, 4), new Dot(5, 0), "name2");
        triangleRepository.addTriangle(triangle1);
        triangleRepository.addTriangle(triangle2);
        triangleRepository.addTriangle(triangle3);
    }

    @AfterClass
    public void tearDown() {
        triangleRepository = null;
        triangle1 = null;
        triangle2 = null;
        triangle3 = null;
    }

    @Test
    public void TriangleSortTest_triangleIdComparator_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle1);
        expected.add(triangle2);
        expected.add(triangle3);
        //when
        triangleRepository.sort(triangleIdComparator);
        //then
        Assert.assertTrue(expected.equals(triangleRepository.getTriangles()));
    }

    @Test
    public void TriangleSortTest_TriangleFirstDotXCoordComparator_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle2);
        expected.add(triangle1);
        expected.add(triangle3);
        //when
        triangleRepository.sort(triangleFirstDotXCoord);
        //then
        Assert.assertTrue(expected.equals(triangleRepository.getTriangles()));
    }

    @Test
    public void TriangleSortTest_TriangleFirstDotYCoordComparator_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle2);
        expected.add(triangle1);
        expected.add(triangle3);
        //when
        triangleRepository.sort(triangleFirstDotYCoord);
        //then
        Assert.assertTrue(expected.equals(triangleRepository.getTriangles()));
    }

    @Test
    public void TriangleSortTest_TriangleNameComparator_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle1);
        expected.add(triangle3);
        expected.add(triangle2);
        //when
        triangleRepository.sort(triangleNameComparator);
        //then
        Assert.assertTrue(expected.equals(triangleRepository.getTriangles()));
    }
}
