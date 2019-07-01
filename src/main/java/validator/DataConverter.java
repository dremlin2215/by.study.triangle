package validator;

import entity.Dot;
import entity.Triangle;
import exception.WrongParamsException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataConverter {

    private static final String RIGHT_COORDINATE_EXPRESSION = "^-?\\d+.?\\d*$";
    private static final String RIGHT_DOT_DIV = " ";
    private static final String RIGHT_COORDINATE_DIV = ",";
    private static DataConverter ourInstance = new DataConverter();

    private DataConverter() {
    }

    public static DataConverter getInstance() {
        return ourInstance;
    }


    public List<Triangle> convertLinesToTriangles(List<String> lines) throws WrongParamsException {

        List<Triangle> triangles = new ArrayList<>();

        for (String line : lines) {

            String[] subStrings = line.split(RIGHT_DOT_DIV);
            if (subStrings.length != 3) {
                throw new WrongParamsException("Triangle should have 3 dots");
            }
            Dot a = convertDot(subStrings[0]);
            Dot b = convertDot(subStrings[1]);
            Dot c = convertDot(subStrings[2]);
            Triangle triangle = new Triangle(a, b, c, "");
            triangles.add(triangle);
        }
        return triangles;
    }

    public Dot convertDot(String line) throws WrongParamsException {

        String[] coordinates = line.split(RIGHT_COORDINATE_DIV);
        if ((coordinates.length != 2) ||
                !isValidDataString(coordinates[0]) ||
                !isValidDataString(coordinates[1])) {
            throw new WrongParamsException("Dot should have 2 coordinates");
        }
        double coordinate0 = Double.parseDouble(coordinates[0]);
        double coordinate1 = Double.parseDouble(coordinates[1]);
        return new Dot(coordinate0, coordinate1);

    }


    private boolean isValidDataString(String string) {
        Pattern p = Pattern.compile(RIGHT_COORDINATE_EXPRESSION);
        Matcher m = p.matcher(string);
        return m.matches();
    }
}
