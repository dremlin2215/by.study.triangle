package observer;

import action.TriangleAction;
import entity.Dot;
import entity.Triangle;
import entity.TriangleParams;
import org.testng.Assert;
import org.testng.annotations.Test;

public class observerTest {

    public Triangle firstTriangle =
            new Triangle(new Dot(1, 1), new Dot(1, 2), new Dot(2, 1), "1st Triangle");
    public TriangleParams params = new TriangleParams(firstTriangle);

    @Test
    public void observerTest_setNewDotA_true() {
        //given - Triangle firstTriangle, TriangleParams params
        //when
        firstTriangle.addObserver(params);
        firstTriangle.setA(new Dot(0, 0));
        firstTriangle.setB(new Dot(0, 4));
        firstTriangle.setC(new Dot(5, 0));
        double actualSquare = params.getSquare();
        double actualPerimeter = params.getPerimeter();
        double expectedSquare = TriangleAction.getInstance().getSquare(firstTriangle);
        double expectedPerimeter = TriangleAction.getInstance().getPerimeter(firstTriangle);
        boolean actual = (actualSquare == expectedSquare) & (actualPerimeter == expectedPerimeter);
        Assert.assertTrue(actual);
    }

}
