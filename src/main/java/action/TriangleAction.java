package action;

import entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleAction {

    private static final TriangleAction ourInstance = new TriangleAction();

    private static final Logger LOGGER = LogManager.getLogger(TriangleAction.class);

    private TriangleCalc validator = TriangleCalc.getInstance();

    private TriangleAction() {
    }

    public static TriangleAction getInstance() {
        return ourInstance;
    }

    public boolean isRightTriangle(Triangle triangle) {
        //90 degree
        LOGGER.info("Method : isRightTriangle");
        double a = Math.pow(validator.getSideAB(triangle), 2);
        double b = Math.pow(validator.getSideBC(triangle), 2);
        double c = Math.pow(validator.getSideAC(triangle), 2);

        LOGGER.info("a=" + a + " b=" + b + " c=" + c);

        return (a + b == c ||
                a + c == b ||
                b + c == a);
    }

    public boolean isEquilateralTriangle(Triangle triangle) {
        // 3 equal sides
        LOGGER.info("Method : isEquilateralTriangle");
        double a = validator.getSideAB(triangle);
        double b = validator.getSideBC(triangle);
        double c = validator.getSideAC(triangle);

        LOGGER.info("a=" + a + " b=" + b + " c=" + c);

        return a == b && b == c;
    }

    public boolean isIsoscelesTriangle(Triangle triangle) {
        //2 equal sides
        LOGGER.info("Method : isIsoscelesTriangle");
        double a = validator.getSideAB(triangle);
        double b = validator.getSideBC(triangle);
        double c = validator.getSideAC(triangle);

        LOGGER.info("a=" + a + " b=" + b + " c=" + c);

        return a == b || b == c || a == c;
    }

    public boolean isAcuteAngled(Triangle triangle) {
        //All corners are less then 90 degree
        LOGGER.info("Method : isAcuteAngled");
        double a = validator.getSideAB(triangle);
        double b = validator.getSideBC(triangle);
        double c = validator.getSideAC(triangle);
        double sqrA = Math.pow(a, 2);
        double sqrB = Math.pow(b, 2);
        double sqrC = Math.pow(c, 2);

        LOGGER.info("a=" + a + " b=" + b + " c=" + c);

        if (a > b && a > c)
            return sqrA < sqrB + sqrC;
        else if (b > c && b > a)
            return sqrB < sqrA + sqrC;
        else return sqrC < sqrA + sqrB;
    }

    public boolean isObtuse(Triangle triangle) {
        //1 corner is more then 90 degree
        LOGGER.info("Method : isObtuse");
        double a = validator.getSideAB(triangle);
        double b = validator.getSideBC(triangle);
        double c = validator.getSideAC(triangle);
        double sqrA = Math.pow(a, 2);
        double sqrB = Math.pow(b, 2);
        double sqrC = Math.pow(c, 2);

        LOGGER.info("a=" + a + " b=" + b + " c=" + c);

        if (a > b && a > c)
            return sqrA > sqrB + sqrC;
        else if (b > c && b > a)
            return sqrB > sqrA + sqrC;
        else return sqrC > sqrA + sqrB;
    }

    public double getPerimeter(Triangle triangle) {
        LOGGER.info("Method : getPerimeter");
        double a = validator.getSideAB(triangle);
        double b = validator.getSideBC(triangle);
        double c = validator.getSideAC(triangle);

        LOGGER.info("a=" + a + " b=" + b + " c=" + c);

        return a + b + c;
    }

    public double getSquare(Triangle triangle) {
        //Geron formula
        LOGGER.info("Method : getSquare");
        double a = validator.getSideAB(triangle);
        double b = validator.getSideBC(triangle);
        double c = validator.getSideAC(triangle);
        double p = getPerimeter(triangle) / 2;

        LOGGER.info("a=" + a + " b=" + b + " c=" + c);

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
