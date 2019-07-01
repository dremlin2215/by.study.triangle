package comparator;

import entity.Dot;
import entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public class ComparatorTest {

    public Triangle firstTriangle =
            new Triangle(new Dot(1, 1), new Dot(1, 2), new Dot(2, 1), "1st Triangle");
    public Triangle secondTriangle =
            new Triangle(new Dot(0, 0), new Dot(0, 3), new Dot(3, 0), "2nd Triangle");
    public Triangle thirdTriangle =
            new Triangle(new Dot(0, 0), new Dot(0, 3), new Dot(3, 0), "3nd Triangle");

    public Comparator triangleIdComparator = new TriangleIdComparator();
    public Comparator triangleNameComparator = new TriangleNameComparator();
    public Comparator triangleFirstDotXCoord = new TriangleFirstDotXCoordComparator();
    public Comparator triangleFirstDotYCoord = new TriangleFirstDotYCoordComparator();

    @Test
    public void TriangleIdComparator_firstLowerThanSecond_true() {
        //given - first and second triangles
        //when
        int compare = triangleIdComparator.compare(firstTriangle, secondTriangle);
        //then
        Assert.assertTrue(compare < 0);
    }

    @Test
    public void TriangleIdComparator_IdEquality_false() {
        //given - first and third triangles
        //when
        int compare = triangleIdComparator.compare(firstTriangle, thirdTriangle);
        //then
        Assert.assertFalse(compare == 0);
    }

    @Test
    public void TriangleFirstDotXCoord_firstLowerThanSecond_false(){
        //given - first and second triangles
        //when
        int compare = triangleFirstDotXCoord.compare(firstTriangle, secondTriangle);
        //then
        Assert.assertFalse(compare < 0);
    }

    @Test
    public void TriangleFirstDotXCoord_CoordEquality_true(){
        //given - third and second triangles
        //when
        int compare = triangleFirstDotXCoord.compare(thirdTriangle, secondTriangle);
        //then
        Assert.assertTrue(compare == 0);
    }

    @Test
    public void TriangleFirstDotYCoord_firstLowerThanSecond_true(){
        //given - first and second triangles
        //when
        int compare = triangleFirstDotYCoord.compare(firstTriangle, secondTriangle);
        //then
        Assert.assertTrue(compare > 0);
    }

    @Test
    public void TriangleFirstDotYCoord_CoordEquality_true(){
        //given - third and second triangles
        //when
        int compare = triangleFirstDotYCoord.compare(thirdTriangle, secondTriangle);
        //then
        Assert.assertTrue(compare == 0);
    }

    @Test
    public void TriangleName_firstLowerThanSecond_true(){
        //given - first and second triangles
        //when
        int compare = triangleNameComparator.compare(firstTriangle, secondTriangle);
        //then
        Assert.assertTrue(compare < 0);
    }

    @Test
    public void TriangleName_CoordEquality_true(){
        //given - third and second triangles
        thirdTriangle.setName("2nd Triangle");
        //when
        int compare = triangleNameComparator.compare(thirdTriangle, secondTriangle);
        //then
        Assert.assertTrue(compare == 0);
    }
}