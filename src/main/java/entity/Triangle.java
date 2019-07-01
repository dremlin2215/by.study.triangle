package entity;

import generator.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private int id;
    private Dot a;
    private Dot b;
    private Dot c;
    private String name;

    private List<TriangleParams> triangleParamsList = new ArrayList<>();

    public Triangle(Dot a, Dot b, Dot c, String name) {
        this.id = IdGenerator.generateId();
        this.a = a;
        this.b = b;
        this.c = c;
        this.name = name;
    }

    public void addObserver(TriangleParams triangleParams) {
        this.triangleParamsList.add(triangleParams);
    }

    public void removeObserver(TriangleParams triangleParams) {
        this.triangleParamsList.remove(triangleParams);
    }

    public Dot getA() {
        return a;
    }

    public void setA(Dot a) {
        this.a = a;
        for (TriangleParams params : this.triangleParamsList) {
            params.update(this);
        }
    }

    public Dot getB() {
        return b;
    }

    public void setB(Dot b) {
        this.b = b;
        for (TriangleParams params : this.triangleParamsList) {
            params.update(this);
        }
    }

    public Dot getC() {
        return c;
    }

    public void setC(Dot c) {
        this.c = c;
        for (TriangleParams params : this.triangleParamsList) {
            params.update(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        for (TriangleParams params : this.triangleParamsList) {
            params.update(this);
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return (a == triangle.a) && (b == triangle.b) && (c == triangle.c);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 37 + (a == null ? 0 : a.hashCode());
        result = result * 37 + (b == null ? 0 : b.hashCode());
        result = result * 37 + (c == null ? 0 : c.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", name=" + name +
                '}';
    }
}
