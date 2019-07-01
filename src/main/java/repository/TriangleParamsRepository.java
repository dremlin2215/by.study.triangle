package repository;

import entity.TriangleParams;

import java.util.HashMap;
import java.util.Map;

public class TriangleParamsRepository {

    private static TriangleParamsRepository ourInstance = new TriangleParamsRepository();
    private Map ParamsMap;

    private TriangleParamsRepository() {
        ParamsMap = new HashMap<Integer, TriangleParams>();
    }

    public static TriangleParamsRepository getInstance() {
        return ourInstance;
    }

    public void put(int id, TriangleParams triangleParams) {

        ParamsMap.put(id, triangleParams);
    }

    public void putAll(Map map) {
        ParamsMap.putAll(map);
    }

    public TriangleParams getParams(int id) {
        TriangleParams params = (TriangleParams) ParamsMap.get(id);
        return params;
    }
}
