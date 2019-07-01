package searchCriteria;

import action.TriangleAction;
import entity.Dot;
import entity.Triangle;

import java.util.function.Predicate;

public class SearchCriteria {

    private static int dotInQuadrant(Dot dot) {
        //x+, y+ == 1st quadrant
        //x+, y- == 2nd quadrant
        //x-, y- == 3rd quadrant
        //x-, y+ == 4th quadrant
        //other results mean that the dot is on the axis
        if ((dot.getX() == 0) | (dot.getY() == 0)) {
            return -1;
        } else if ((dot.getX() > 0) & (dot.getY() > 0)) {
            return 1;
        } else if ((dot.getX() > 0) & (dot.getY() < 0)) {
            return 2;
        } else if ((dot.getX() < 0) & (dot.getY() < 0)) {
            return 3;
        } else {
            return 4;
        }
    }


    public static Predicate<Triangle> isTriangleInQuadrant(int quadrant) {

        return p -> quadrant >= 1 && quadrant <= 4 &&
                dotInQuadrant(p.getA()) == quadrant &&
                dotInQuadrant(p.getB()) == quadrant &&
                dotInQuadrant(p.getC()) == quadrant;
    }

    public static Predicate<Triangle> isId(int id) {
        return var -> var.getId() == id;
    }

    public static Predicate<Triangle> isIdIn(int min, int max) {
        return var -> var.getId() > min && var.getId() < max;
    }

    public static Predicate<Triangle> isName(String name) {
        return var -> var.getName() == name;
    }

    public static Predicate<Triangle> isPerimeterIn(int min, int max) {
        return var -> TriangleAction.getInstance().getPerimeter(var) > min &&
                TriangleAction.getInstance().getPerimeter(var) < max;
    }

    public static Predicate<Triangle> isSquareIn(int min, int max) {
        return var -> TriangleAction.getInstance().getSquare(var) > min &&
                TriangleAction.getInstance().getSquare(var) < max;
    }
}