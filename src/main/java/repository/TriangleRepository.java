package repository;

import entity.Triangle;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TriangleRepository {
    private static TriangleRepository ourInstance = new TriangleRepository();
    private List<Triangle> triangleList;

    private TriangleRepository() {
        triangleList = new ArrayList<Triangle>();
    }

    public static TriangleRepository getInstance() {
        return ourInstance;
    }

    public void addTriangle(Triangle triangle) {
        triangleList.add(triangle);
    }

    public void addTriangles(List<Triangle> triangles) {
        triangleList.addAll(triangles);
    }

    public Triangle getTriangle(int position) {
        return triangleList.get(position);
    }

    public List<Triangle> getTriangles(){
        return triangleList;
    }

    public void sort(Comparator<Triangle> comparator){
        Collections.sort(triangleList, comparator);
    }

    public List<Triangle> filter(Predicate<Triangle> predicate){
        return triangleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());

    }



}
