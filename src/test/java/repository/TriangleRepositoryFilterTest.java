package repository;

import entity.Dot;
import entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import searchCriteria.SearchCriteria;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TriangleRepositoryFilterTest {

    public TriangleRepository triangleRepository = TriangleRepository.getInstance();
    public Triangle triangle1;
    public Triangle triangle2;
    public Triangle triangle3;

    public Predicate<Triangle> isTriangleInQuadrant1 = SearchCriteria.isTriangleInQuadrant(1);
    public Predicate<Triangle> isTriangleInQuadrant5 = SearchCriteria.isTriangleInQuadrant(5);
    public Predicate<Triangle> isId = SearchCriteria.isId(1);
    public Predicate<Triangle> isIdIn = SearchCriteria.isIdIn(2, 4);
    public Predicate<Triangle> isPerimeterIn = SearchCriteria.isPerimeterIn(4, 16);
    public Predicate<Triangle> isSquareIn = SearchCriteria.isSquareIn(9, 12);
    public Predicate<Triangle> isName = SearchCriteria.isName("name2");

    @BeforeClass
    public void setUp() {
        triangle1 = new Triangle(new Dot(1, 1), new Dot(1, 3), new Dot(3, 1), "name1");
        triangle2 = new Triangle(new Dot(0, 0), new Dot(0, 5), new Dot(2, 0), "name3");
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
    public void triangleRepositoryFilterTest_isTriangleInQuadrant1_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle1);
        //when
        List actual = triangleRepository.filter(isTriangleInQuadrant1);
        //then
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void triangleRepositoryFilterTest_isTriangleInQuadrant5_true() {
        //given
        //when
        List actual = triangleRepository.filter(isTriangleInQuadrant5);
        //then
        Assert.assertTrue(actual.size()==0);
    }

    @Test
    public void triangleRepositoryFilterTest_isId1_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle1);
        //when
        List actual = triangleRepository.filter(isId);
        //then
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void triangleRepositoryFilterTest_isId2to4_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle3);
        //when
        List actual = triangleRepository.filter(isIdIn);
        //then
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void triangleRepositoryFilterTest_isPerimeterIn_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle1);
        expected.add(triangle2);
        expected.add(triangle3);
        //when
        List actual = triangleRepository.filter(isPerimeterIn);
        //then
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void triangleRepositoryFilterTest_isSquareIn_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle3);
        //when
        List actual = triangleRepository.filter(isSquareIn);
        //then
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void triangleRepositoryFilterTest_isName_true() {
        //given
        List<Triangle> expected = new ArrayList<>();
        expected.add(triangle3);
        //when
        List actual = triangleRepository.filter(isName);
        //then
        Assert.assertTrue(expected.equals(actual));
    }
}
