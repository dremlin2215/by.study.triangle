package action;

import entity.Dot;
import entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleCalc {

    private static final TriangleCalc ourInstance = new TriangleCalc();

    private static final Logger LOGGER = LogManager.getLogger(TriangleCalc.class);

    private static final int PRECISE = 2;

    private TriangleCalc() {
    }

    public static TriangleCalc getInstance() {
        return ourInstance;
    }


    private double roundResult(double d, int precise) {
        precise = 10 ^ precise;
        d = d * precise;
        int i = (int) Math.round(d);
        return (double) i / precise;
    }

    private double getSide(Dot a, Dot b) {
        return Math.abs(Math.sqrt(Math.pow((b.getX() - a.getX()), 2) +
                Math.pow((b.getY() - a.getY()), PRECISE)));
    }

    public double getSideAB(Triangle triangle) {
        double side = getSide(triangle.getA(), triangle.getB());
        return roundResult(side, PRECISE);
    }

    public double getSideAC(Triangle triangle) {
        double side = getSide(triangle.getA(), triangle.getC());
        return roundResult(side, PRECISE);
    }

    public double getSideBC(Triangle triangle) {
        double side = getSide(triangle.getB(), triangle.getC());
        return roundResult(side, PRECISE);
    }

    public boolean isTriangle(Triangle triangle) {

        double a = getSideAB(triangle);
        double b = getSideBC(triangle);
        double c = getSideAC(triangle);
        LOGGER.info("Method : isTriangle");
        return (a + b < c && a + c < b && b + c < a &&
                a != 0 && b != 0 && c != 0);
    }
}
