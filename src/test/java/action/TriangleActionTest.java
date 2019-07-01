package action;

import entity.Dot;
import entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleActionTest {

    //Test naming order - Test name _ input parameter _ expected result

    @Test
    public void isRightTriangle_validRightTriangle_true() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 0), new Dot(4, 0), new Dot(0, 3),"");
        TriangleAction action = TriangleAction.getInstance();
        //when
        boolean isRightTriangle = action.isRightTriangle(triangle);
        //then
        Assert.assertTrue(isRightTriangle);
    }

    @Test
    public void isRightTriangle_invalidRightTriangle_false() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 0), new Dot(2, 0), new Dot(4, 12),"");
        TriangleAction action = TriangleAction.getInstance();
        //when
        boolean isRightTriangle = action.isRightTriangle(triangle);
        //then
        Assert.assertFalse(isRightTriangle);
        //If input data is not triangle - the result is incorrect
    }

    @Test
    public void isEquilateralTriangle_validEquilateralTriangle_true() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 0), new Dot(8, 0), new Dot(4, 6.92820323),"");
        TriangleAction action = TriangleAction.getInstance();
        //when
        boolean isEquilateralTriangle = action.isEquilateralTriangle(triangle);
        //then
        Assert.assertTrue(isEquilateralTriangle);
    }

    @Test
    public void isEquilateralTriangle_invalidEquilateralTriangle_false() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 0), new Dot(3, 0), new Dot(0, 13),"");
        TriangleAction action = TriangleAction.getInstance();
        //when
        boolean isEquilateralTriangle = action.isEquilateralTriangle(triangle);
        //then
        Assert.assertFalse(isEquilateralTriangle);
    }

    @Test
    public void isIsoscelesTriangle_validIsoscelesTriangle_true() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 0), new Dot(4, 0), new Dot(2, 5),"");
        TriangleAction action = TriangleAction.getInstance();
        //when
        boolean isIsoscelesTriangle = action.isIsoscelesTriangle(triangle);
        Assert.assertTrue(isIsoscelesTriangle);
    }

    @Test
    public void isAcuteAngled_validAcuteAngledTriangle_true() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 0), new Dot(4, 0), new Dot(2, 5),"");
        TriangleAction action = TriangleAction.getInstance();
        //when
        boolean isAcuteAngled = action.isAcuteAngled(triangle);
        //then
        Assert.assertTrue(isAcuteAngled);
    }

    @Test
    public void isObtuse_validObtuseTriangle_true() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 0), new Dot(12, 0), new Dot(6, 3),"");
        TriangleAction action = TriangleAction.getInstance();
        //when
        boolean isObtuse = action.isObtuse(triangle);
        //then
        Assert.assertTrue(isObtuse);
    }

    @Test
    public void getPerimeter_validTriangle_true() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 4), new Dot(3, 0), new Dot(0, 0), "");
        TriangleAction action = TriangleAction.getInstance();
        double perimeter = 12;
        //when
        double getPerimeter = action.getPerimeter(triangle);
        //then
        Assert.assertEquals(getPerimeter, perimeter);
    }

    @Test
    public void getSquare_validTriangle_true() {
        //given
        Triangle triangle = new Triangle(new Dot(0, 4), new Dot(3, 0), new Dot(0, 0), "");
        TriangleAction action = TriangleAction.getInstance();
        double square = 6;
        //when
        double getSquare = action.getSquare(triangle);
        //then
        Assert.assertEquals(getSquare, square);
    }
}
